package br.com.danielwisky.pibbaeta.api.v1;

import static org.springframework.http.HttpStatus.CREATED;

import br.com.danielwisky.pibbaeta.api.v1.resources.request.DispositivoRequest;
import br.com.danielwisky.pibbaeta.services.DispositivoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/dispositivo")
@AllArgsConstructor
public class DispositivoRestController {

  private DispositivoService dispositivoService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity adiciona(@Valid @RequestBody DispositivoRequest dispositivo) {
    dispositivoService.adiciona(dispositivo.toModel());
    return ResponseEntity.status(CREATED).build();
  }
}