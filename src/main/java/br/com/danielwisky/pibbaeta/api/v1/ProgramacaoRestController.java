package br.com.danielwisky.pibbaeta.api.v1;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/programacao")
@AllArgsConstructor
public class ProgramacaoRestController {

  private ProgramacaoService programacaoService;

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody
  AgendaResponse lista() {
    return programacaoService.getAgendaResponse();
  }
}