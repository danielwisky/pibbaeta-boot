package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Usuario;
import java.util.List;

public interface UsuarioService {

  void adiciona(final Usuario usuario);

  void altera(final Usuario usuario);

  List<Usuario> lista();

  Usuario busca(final String id);

  Usuario preparaParaAtualizar(final Usuario usuario, final String id);

  Usuario preparaParaAtualizarAutenticado(final Usuario usuario);

  boolean checaExisteLogin(final String login, final String id);

  boolean checaExisteEmail(final String email, final String id);
}