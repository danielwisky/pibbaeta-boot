package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.danielwisky.pibbaeta.models.Usuario;
import br.com.danielwisky.pibbaeta.repositories.UsuarioRepository;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private UsuarioRepository usuarioRepository;

  @Override
  public void adiciona(Usuario usuario) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    usuario.setSenha(encoder.encode(usuario.getSenha()));
    usuarioRepository.insert(usuario);
  }

  @Override
  public void altera(Usuario usuario) {

    if (isNotBlank(usuario.getNovaSenha())) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      usuario.setSenha(encoder.encode(usuario.getNovaSenha()));
    }

    usuarioRepository.save(usuario);
  }

  @Override
  public List<Usuario> lista() {
    return usuarioRepository.findAll();
  }

  @Override
  public Usuario busca(String id) {
    return usuarioRepository.findOne(id);
  }

  @Override
  public Usuario preparaParaAtualizar(Usuario usuario, String id) {

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
}