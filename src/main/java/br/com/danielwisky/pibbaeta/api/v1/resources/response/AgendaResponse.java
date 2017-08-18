package br.com.danielwisky.pibbaeta.api.v1.resources.response;

import br.com.danielwisky.pibbaeta.models.Programacao;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class AgendaResponse {

  private List<Programacao> programacoes;
  private LocalDateTime dataAtualizacao;

  public AgendaResponse(List<Programacao> programacoes) {
    this.programacoes = programacoes;
    this.dataAtualizacao = LocalDateTime.now();
  }
}