package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.util.List;

public interface ProgramacaoService {

  AgendaResponse getAgendaResponse();

  void adiciona(Programacao programacao);

  void altera(Programacao programacao, String id);

  Programacao busca(String id);

  List<Programacao> pesquisa(String titulo, Status status);
}