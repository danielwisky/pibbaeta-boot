package br.com.danielwisky.pibbaeta.api.v1.resources.request;

import br.com.danielwisky.pibbaeta.models.Dispositivo;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
public class DispositivoRequest {

  @NotBlank
  private String token;

  public Dispositivo toModel() {
    final Dispositivo dispositivo = new Dispositivo();
    dispositivo.setToken(getToken());
    return dispositivo;
  }
}