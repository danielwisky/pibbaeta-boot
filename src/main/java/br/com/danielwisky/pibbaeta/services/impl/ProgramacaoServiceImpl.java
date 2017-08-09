package br.com.danielwisky.pibbaeta.services.impl;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.repositories.ProgramacaoRepository;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProgramacaoServiceImpl implements ProgramacaoService {

  private ProgramacaoRepository programacaoRepository;

  @Override
  public AgendaResponse getAgendaResponse() {
    List<Programacao> programacoes = programacaoRepository.findAll();
    return new AgendaResponse(programacoes);
  }
}