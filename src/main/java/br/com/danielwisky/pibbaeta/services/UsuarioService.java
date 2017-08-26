package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Usuario;
import java.util.List;

public interface UsuarioService {

  void adiciona(Usuario usuario);

  void altera(Usuario usuario);

  List<Usuario> lista();

  Usuario busca(String id);

  Usuario preparaParaAtualizar(Usuario usuario, String id);

  Usuario preparaParaAtualizarAutenticado(Usuario usuario);

  boolean checaExisteLogin(String login, String id);

  boolean checaExisteEmail(String email, String id);
}