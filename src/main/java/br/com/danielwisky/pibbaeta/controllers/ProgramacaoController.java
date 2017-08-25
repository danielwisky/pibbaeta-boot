package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import br.com.danielwisky.pibbaeta.services.TipoProgramacaoService;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/programacao")
@AllArgsConstructor
public class ProgramacaoController {

  private MessageSource messageSource;
  private ProgramacaoService programacaoService;
  private TipoProgramacaoService tipoProgramacaoService;

  @RequestMapping(method = RequestMethod.GET)
  public String lista(final Model model) {
    loadFormDependencies(model);
    return "programacao/lista";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String salva(@Valid final Programacao programacao,
      final BindingResult bindingResult, final RedirectAttributes redirectAttributes,
      final Locale locale, final Model model) {

    if (bindingResult.hasErrors()) {
      return adiciona(programacao, model);
    }

    programacaoService.adiciona(programacao);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("inclusao.sucesso", null, locale));
    return "redirect:/programacao";
  }

  @RequestMapping("/adicionar")
  public String adiciona(final Programacao programacao, final Model model) {
    loadFormDependencies(model);
    return "programacao/adicionar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String detalhe(@PathVariable("id") final String id, final Programacao programacao,
      final Model model, final boolean containErrors) {

    final Programacao prog = containErrors ? programacao : programacaoService.busca(id);

    model.addAttribute("programacao", prog);
    loadFormDependencies(model);
    return "programacao/editar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String atualiza(@PathVariable("id") final String id, @Valid final Programacao programacao,
      final BindingResult bindingResult, final RedirectAttributes redirectAttributes,
      final Locale locale, final Model model) {

    if (bindingResult.hasErrors()) {
      return detalhe(id, programacao, model, true);
    }

    programacaoService.altera(programacao, id);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("alteracao.sucesso", null, locale));
    return "redirect:/programacao";
  }

  @RequestMapping(value = "/pesquisa")
  public @ResponseBody
  List<Programacao> pesquisa(final String titulo, final Status status) {
    return programacaoService.pesquisa(titulo, status);
  }

  private Model loadFormDependencies(final Model model) {
    model.addAttribute("menu", "cadastro");
    model.addAttribute("tipos", tipoProgramacaoService.lista());
    model.addAttribute("statuses", Status.values());
    return model;
  }
}