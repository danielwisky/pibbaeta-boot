package br.com.danielwisky.pibbaeta.api.v1.resources.response;

import static java.util.Objects.nonNull;

import br.com.danielwisky.pibbaeta.models.Programacao;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class ProgramacaoResponse {

  private String id;
  private String titulo;
  private String descricao;
  private ZonedDateTime dataInicio;
  private ZonedDateTime dataTermino;
  private String local;
  private String endereco;
  private String urlBanner;
  private TipoResponse tipo;
  private String observacao;
  private String status;

  public ProgramacaoResponse(Programacao programacao) {
    this.id = programacao.getId();
    this.titulo = programacao.getTitulo();
    this.descricao = programacao.getDescricao();
    this.dataInicio = programacao.getDataInicio().atZone(ZoneId.of("America/Sao_Paulo"));
    this.dataTermino = programacao.getDataTermino().atZone(ZoneId.of("America/Sao_Paulo"));
    this.local = programacao.getLocal();
    this.endereco = programacao.getEndereco();
    this.urlBanner = programacao.getUrlBanner();
    this.observacao = programacao.getObservacao();

    if (nonNull(programacao.getTipo())) {
      this.tipo = new TipoResponse(programacao.getTipo());
    }

    if (nonNull(programacao.getStatus())) {
      this.status = programacao.getStatus().toString();
    }
  }

  public static List<ProgramacaoResponse> toList(List<Programacao> programacoes) {
    return programacoes.stream().map(ProgramacaoResponse::new).collect(Collectors.toList());
  }
}