package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.Usuario;
import br.com.danielwisky.pibbaeta.models.enums.Papel;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import br.com.danielwisky.pibbaeta.validators.UsuarioValidator;
import java.util.List;
import java.util.Locale;
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
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

  private UsuarioService usuarioService;
  private UsuarioValidator usuarioValidator;
  private MessageSource messageSource;

  @RequestMapping(method = RequestMethod.GET)
  public String lista(final Model model) {
    loadFormDependencies(model);
    return "usuario/lista";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String salva(final Usuario usuario, final BindingResult bindingResult,
      final RedirectAttributes redirectAttributes, final Locale locale, final Model model) {

    usuarioValidator.validateInsert(usuario, bindingResult);

    if (bindingResult.hasErrors()) {
      return adiciona(usuario, model);
    }

    usuarioService.adiciona(usuario);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("inclusao.sucesso", null, locale));
    return "redirect:/usuario";
  }

  @RequestMapping("/adicionar")
  public String adiciona(final Usuario usuario, final Model model) {
    loadFormDependencies(model);
    return "usuario/adicionar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String detalhe(@PathVariable("id") final String id, final Usuario usuario,
      final Model model, final boolean containErrors) {

    final Usuario user = containErrors ? usuario : usuarioService.busca(id);

    model.addAttribute("usuario", user);
    loadFormDependencies(model);
    return "usuario/editar";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String atualiza(@PathVariable("id") final String id, final Usuario usuario,
      final BindingResult bindingResult, final RedirectAttributes redirectAttributes,
      final Locale locale, final Model model) {

    final Usuario usuarioParaAtualizar = usuarioService.preparaParaAtualizar(usuario, id);
    usuarioValidator.validateUpdate(usuarioParaAtualizar, bindingResult);

    if (bindingResult.hasErrors()) {
      return detalhe(id, usuario, model, true);
    }

    usuarioService.altera(usuarioParaAtualizar);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("alteracao.sucesso", null, locale));
    return "redirect:/usuario";
  }

  @RequestMapping(value = "/pesquisa")
  public @ResponseBody
  List<Usuario> pesquisa() {
    return usuarioService.lista();
  }

  private Model loadFormDependencies(final Model model) {
    model.addAttribute("menu", "cadastro");
    model.addAttribute("statuses", Status.values());
    model.addAttribute("papeis", Papel.values());
    return model;
  }
}