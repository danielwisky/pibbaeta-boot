package br.com.danielwisky.pibbaeta.api.v1.resources.response;

import br.com.danielwisky.pibbaeta.models.Tipo;
import lombok.Getter;

@Getter
public class TipoResponse {

  private String descricao;

  public TipoResponse(Tipo tipo) {
    this.descricao = tipo.getDescricao();
  }
}