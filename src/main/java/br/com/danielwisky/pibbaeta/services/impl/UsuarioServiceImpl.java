package br.com.danielwisky.pibbaeta.services.impl;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.pibbaeta.repositories.UsuarioRepository;
import br.com.danielwisky.pibbaeta.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return ofNullable(usuarioRepository.findByLogin(username))
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
  }
}