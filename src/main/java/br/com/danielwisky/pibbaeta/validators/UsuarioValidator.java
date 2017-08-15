package br.com.danielwisky.pibbaeta.validators;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.danielwisky.pibbaeta.models.Usuario;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@Component
@AllArgsConstructor
public class UsuarioValidator {

  private UsuarioService usuarioService;
  private Validator validator;

  public void validateInsert(Usuario usuario, BindingResult bindingResult) {

    validate(usuario, bindingResult);

    if (isNotBlank(usuario.getSenha())
        && !StringUtils.equals(usuario.getSenha(), usuario.getConfirmarSenha())) {
      bindingResult.rejectValue("confirmarSenha", "senha.nao.confere");
    }
  }

  public void validateUpdate(Usuario usuario, BindingResult bindingResult) {

    validate(usuario, bindingResult);

    if (isNotBlank(usuario.getNovaSenha())
        && !StringUtils.equals(usuario.getNovaSenha(), usuario.getConfirmarSenha())) {
      bindingResult.rejectValue("confirmarSenha", "senha.nao.confere");
    }
  }

  private void validate(Usuario usuario, BindingResult bindingResult) {

    validator.validate(usuario, bindingResult);

    if (isNotBlank(usuario.getLogin())
        && usuarioService.checaExisteLogin(usuario.getLogin(), usuario.getId())) {
      bindingResult.rejectValue("login", "existe.usuario.cadastrado.login", new Object[]{usuario.getLogin()}, null);
    }

    if (isNotBlank(usuario.getEmail())
        && usuarioService.checaExisteEmail(usuario.getEmail(), usuario.getId())) {
      bindingResult.rejectValue("email", "existe.usuario.cadastrado.email", new Object[]{usuario.getEmail()}, null);
    }
  }
}