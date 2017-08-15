package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.Usuario;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import br.com.danielwisky.pibbaeta.validators.UsuarioValidator;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/configuracao")
@AllArgsConstructor
public class ConfiguracaoController {

  private MessageSource messageSource;
  private UsuarioService usuarioService;
  private UsuarioValidator usuarioValidator;

  @RequestMapping(method = RequestMethod.GET)
  public String config(Usuario usuario, boolean containErrors, Model model) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Usuario user = containErrors ? usuario : (Usuario) authentication.getPrincipal();

    model.addAttribute("usuario", user);
    model.addAttribute("menu", "autenticado");

    return "configuracao/config";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String salva(Usuario usuario, BindingResult bindingResult,
      RedirectAttributes redirectAttributes, Locale locale, Model model) {

    Usuario usuarioParaAtualizar = usuarioService.preparaParaAtualizarAutenticado(usuario);
    usuarioValidator.validateUpdate(usuarioParaAtualizar, bindingResult);

    if (bindingResult.hasErrors()) {
      return config(usuario, true, model);
    }

    usuarioService.altera(usuarioParaAtualizar);

    redirectAttributes.addFlashAttribute("sucesso",
        messageSource.getMessage("alteracao.sucesso", null, locale));
    return "redirect:/configuracao";
  }
}
