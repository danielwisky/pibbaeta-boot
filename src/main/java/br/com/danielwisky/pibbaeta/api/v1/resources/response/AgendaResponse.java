package br.com.danielwisky.pibbaeta.api.v1.resources.response;

import br.com.danielwisky.pibbaeta.models.Programacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class AgendaResponse {

  private List<Programacao> programacaos;
  private LocalDateTime dataAtualizacao;

  public AgendaResponse(List<Programacao> programacoes) {
    this.programacaos = programacoes;
    this.dataAtualizacao = LocalDateTime.now();
  }
}