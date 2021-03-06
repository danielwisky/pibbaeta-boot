package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.danielwisky.pibbaeta.models.Usuario;
import br.com.danielwisky.pibbaeta.repositories.UsuarioRepository;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private UsuarioRepository usuarioRepository;

  @Override
  public void adiciona(final Usuario usuario) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    usuario.setSenha(encoder.encode(usuario.getSenha()));
    usuarioRepository.insert(usuario);
  }

  @Override
  public void altera(final Usuario usuario) {

    if (isNotBlank(usuario.getNovaSenha())) {
      final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      usuario.setSenha(encoder.encode(usuario.getNovaSenha()));
    }

    usuarioRepository.save(usuario);
  }

  @Override
  public List<Usuario> lista() {
    return usuarioRepository.findAll();
  }

  @Override
  public Usuario busca(final String id) {
    return usuarioRepository.findOne(id);
  }

  @Override
  public Usuario preparaParaAtualizar(final Usuario usuario, final String id) {

    Usuario user = usuarioRepository.findOne(id);

    user.setNome(StringUtils.trim(usuario.getNome()));
    user.setEmail(StringUtils.trim(usuario.getEmail()));
    user.setLogin(StringUtils.trim(usuario.getLogin()));
    user.setStatus(usuario.getStatus());
    user.setPapeis(usuario.getPapeis());
    user.setNovaSenha(usuario.getNovaSenha());
    user.setConfirmarSenha(usuario.getConfirmarSenha());

    return user;
  }

  @Override
  public Usuario preparaParaAtualizarAutenticado(final Usuario usuario) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Usuario autenticado = (Usuario) authentication.getPrincipal();

    autenticado.setNome(StringUtils.trim(usuario.getNome()));
    autenticado.setEmail(StringUtils.trim(usuario.getEmail()));
    autenticado.setLogin(StringUtils.trim(usuario.getLogin()));
    autenticado.setConfirmarSenha(usuario.getConfirmarSenha());
    autenticado.setNovaSenha(usuario.getNovaSenha());

    return autenticado;
  }

  @Override
  public boolean checaExisteLogin(final String login, final String id) {
    return isBlank(id) ?
        usuarioRepository.existsByLogin(login) :
        usuarioRepository.existsByLoginAndIdNot(login, id);
  }

  @Override
  public boolean checaExisteEmail(final String email, final String id) {
    return isBlank(id) ?
        usuarioRepository.existsByEmail(email) :
        usuarioRepository.existsByEmailAndIdNot(email, id);
  }
}