package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.TipoProgramacao;
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
@RequestMapping("/tipo-programacao")
@AllArgsConstructor
public class TipoProgramacaoController {

  private MessageSource messageSource;
  private TipoProgramacaoService tipoProgramacaoService;

  @RequestMapping(method = RequestMethod.GET)
  public String lista(final Model model) {
    loadFormDependencies(model);
    return "tipoProgramacao/lista";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String salva(@Valid final TipoProgramacao tipoProgramacao,
      final BindingResult bindingResult, final RedirectAttributes redirectAttributes,
      final Locale locale, final Model model) {

    if (bindingResult.hasErrors()) {
      return adiciona(tipoProgramacao, model);
    }

    tipoProgramacaoService.adiciona(tipoProgramacao);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("inclusao.sucesso", null, locale));
    return "redirect:/tipo-programacao";
  }

  @RequestMapping("/adicionar")
  public String adiciona(final TipoProgramacao tipoProgramacao, final Model model) {
    loadFormDependencies(model);
    return "tipoProgramacao/adicionar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String detalhe(@PathVariable("id") final String id, final TipoProgramacao tipoProgramacao,
      final Model model, final boolean containErrors) {

    final TipoProgramacao prog = containErrors ? tipoProgramacao : tipoProgramacaoService.busca(id);

    model.addAttribute("tipoProgramacao", prog);
    loadFormDependencies(model);
    return "tipoProgramacao/editar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String atualiza(@PathVariable("id") final String id,
      @Valid final TipoProgramacao tipoProgramacao,
      final BindingResult bindingResult, final RedirectAttributes redirectAttributes,
      final Locale locale, final Model model) {

    if (bindingResult.hasErrors()) {
      return detalhe(id, tipoProgramacao, model, true);
    }

    tipoProgramacaoService.altera(tipoProgramacao, id);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("alteracao.sucesso", null, locale));
    return "redirect:/tipo-programacao";
  }

  @RequestMapping(value = "/pesquisa")
  public @ResponseBody
  List<TipoProgramacao> pesquisa() {
    return tipoProgramacaoService.lista();
  }

  private Model loadFormDependencies(final Model model) {
    model.addAttribute("menu", "cadastro");
    return model;
  }
}