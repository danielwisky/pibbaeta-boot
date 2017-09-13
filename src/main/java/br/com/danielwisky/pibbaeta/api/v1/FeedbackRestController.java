package br.com.danielwisky.pibbaeta.api.v1;

import static org.springframework.http.HttpStatus.CREATED;

import br.com.danielwisky.pibbaeta.api.v1.resources.request.FeedbackRequest;
import br.com.danielwisky.pibbaeta.api.v1.resources.request.PedidoOracaoRequest;
import br.com.danielwisky.pibbaeta.services.FeedbackService;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/feedback")
@AllArgsConstructor
public class FeedbackRestController {

  private FeedbackService feedbackService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity adiciona(@Valid @RequestBody FeedbackRequest feedback) {
    feedbackService.adiciona(feedback.toModel());
    return ResponseEntity.status(CREATED).build();
  }
}
