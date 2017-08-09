package br.com.danielwisky.pibbaeta.api.v1;

import br.com.danielwisky.pibbaeta.api.v1.resources.request.PedidoOracaoRequest;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/pedido-oracao")
@AllArgsConstructor
public class PedidoOracaoRestController {

  private PedidoOracaoService pedidoOracaoService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity adiciona(@Valid @RequestBody PedidoOracaoRequest pedidoOracao) {
    pedidoOracaoService.adiciona(pedidoOracao.toModel());
    return ResponseEntity.ok(HttpStatus.CREATED);
  }
}
