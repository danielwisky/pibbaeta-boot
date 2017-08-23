package br.com.danielwisky.pibbaeta.services.impl;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.repositories.ProgramacaoRepository;
import br.com.danielwisky.pibbaeta.services.DispositivoService;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProgramacaoServiceImpl implements ProgramacaoService {

  private ProgramacaoRepository programacaoRepository;
  private DispositivoService dispositivoService;

  @Override
  public void adiciona(Programacao programacao) {
    preparaParaSalvar(programacao, programacao);
    programacaoRepository.insert(programacao);
    dispositivoService.enviaNotificacao(programacao);
  }

  @Override
  public void altera(Programacao programacao, String id) {
    Programacao programacaoParaAtualizar = programacaoRepository.findOne(id);
    preparaParaSalvar(programacao, programacaoParaAtualizar);
    programacaoRepository.save(programacaoParaAtualizar);
    dispositivoService.enviaNotificacao(programacaoParaAtualizar);
  }

  @Override
  public Programacao busca(String id) {
    return programacaoRepository.findOne(id);
  }

  public List<Programacao> pesquisa(String titulo, Status status) {
    return ofNullable(status)
        .map(s -> programacaoRepository.findByTituloLikeAndStatusOrderByDataTerminoDesc(titulo, s))
        .orElse(programacaoRepository.findByTituloLikeOrderByDataTerminoDesc(titulo));
  }

  @Override
  public List<Programacao> pesquisa(LocalDateTime versao) {
    return ofNullable(versao)
        .map(data -> programacaoRepository.findByDataAtualizacaoAfter(data))
        .orElse(programacaoRepository.findByStatus(Status.ATIVO));
  }

  private void preparaParaSalvar(Programacao programacao, Programacao programacaoParaSalvar) {
    programacaoParaSalvar.setLocal(trimToNull(programacao.getLocal()));
    programacaoParaSalvar.setDescricao(trimToNull(programacao.getDescricao()));
    programacaoParaSalvar.setEndereco(trimToNull(programacao.getEndereco()));
    programacaoParaSalvar.setTitulo(trimToNull(programacao.getTitulo()));
    programacaoParaSalvar.setStatus(programacao.getStatus());
    programacaoParaSalvar.setTipo(programacao.getTipo());
    programacaoParaSalvar.setDataAtualizacao(LocalDateTime.now());
  }
}