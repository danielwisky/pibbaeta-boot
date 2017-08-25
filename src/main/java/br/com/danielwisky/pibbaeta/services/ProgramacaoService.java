package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.time.LocalDateTime;
import java.util.List;

public interface ProgramacaoService {

  void adiciona(final Programacao programacao);

  void altera(final Programacao programacao, final String id);

  Programacao busca(final String id);

  List<Programacao> pesquisa(final String titulo, final Status status);

  List<Programacao> pesquisa(final LocalDateTime versao);
}