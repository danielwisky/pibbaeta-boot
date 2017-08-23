package br.com.danielwisky.pibbaeta.api.v1;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/programacao")
@AllArgsConstructor
public class ProgramacaoRestController {

  private ProgramacaoService programacaoService;

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody
  AgendaResponse lista(
      @RequestParam(name = "versao", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime versao) {
    List<Programacao> programacoes = programacaoService.pesquisa(versao);
    return new AgendaResponse(programacoes);
  }
}