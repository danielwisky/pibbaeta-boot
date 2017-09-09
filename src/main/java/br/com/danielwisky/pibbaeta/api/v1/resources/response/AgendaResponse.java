package br.com.danielwisky.pibbaeta.api.v1.resources.response;

import br.com.danielwisky.pibbaeta.models.Programacao;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class AgendaResponse {

  private List<ProgramacaoResponse> programacoes;
  private ZonedDateTime dataAtualizacao;

  public AgendaResponse(List<Programacao> programacoes) {
    this.programacoes = ProgramacaoResponse.toList(programacoes);
    this.dataAtualizacao = ZonedDateTime.now();
  }

  public AgendaResponse(Programacao programacao) {
    this.programacoes = ProgramacaoResponse.toList(Arrays.asList(programacao));
    this.dataAtualizacao = ZonedDateTime.now();
  }
}