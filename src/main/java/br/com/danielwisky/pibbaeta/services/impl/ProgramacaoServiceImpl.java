package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.*;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.repositories.ProgramacaoRepository;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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

  @Override
  public void adiciona(Programacao programacao) {
    preparaParaSalvar(programacao, programacao);
    programacaoRepository.insert(programacao);
  }

  @Override
  public void altera(Programacao programacao, String id) {
    Programacao programacaoParaAtualizar = programacaoRepository.findOne(id);
    preparaParaSalvar(programacao, programacaoParaAtualizar);
    programacaoRepository.save(programacaoParaAtualizar);
  }

  @Override
  public Programacao busca(String id) {
    return programacaoRepository.findOne(id);
  }

  @Override
  public List<Programacao> pesquisa(String titulo, Status status) {
    return programacaoRepository.findByTituloAndStatus(titulo, status);
  }

  private void preparaParaSalvar(Programacao programacao, Programacao programacaoParaSalvar) {
    programacaoParaSalvar.setLocal(trimToNull(programacao.getLocal()));
    programacaoParaSalvar.setDescricao(trimToNull(programacao.getDescricao()));
    programacaoParaSalvar.setEndereco(trimToNull(programacao.getEndereco()));
    programacaoParaSalvar.setTitulo(trimToNull(programacao.getTitulo()));
    programacaoParaSalvar.setStatus(programacao.getStatus());
    programacaoParaSalvar.setDataAtualizacao(LocalDateTime.now());
  }
}