package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.time.LocalDateTime;
import java.util.List;

public interface ProgramacaoService {

  void adiciona(Programacao programacao);

  void altera(Programacao programacao);

  void altera(Programacao programacao, String id);

  Programacao busca(String id);

  List<Programacao> pesquisa(String titulo, Status status);

  List<Programacao> pesquisa(LocalDateTime versao);

  List<Programacao> pesquisa(LocalDateTime dataTermino, Status status);
}