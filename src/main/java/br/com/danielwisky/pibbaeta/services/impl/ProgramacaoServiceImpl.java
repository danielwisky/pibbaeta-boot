package br.com.danielwisky.pibbaeta.services.impl;

import static java.util.Objects.nonNull;
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
  public void adiciona(final Programacao programacao) {
    preparaParaSalvar(programacao, programacao);
    programacaoRepository.insert(programacao);
    dispositivoService.enviaNotificacao(programacao);
  }

  @Override
  public void altera(Programacao programacao) {
    programacaoRepository.save(programacao);
  }

  @Override
  public void altera(final Programacao programacao, final String id) {
    Programacao programacaoParaAtualizar = programacaoRepository.findOne(id);
    preparaParaSalvar(programacao, programacaoParaAtualizar);
    programacaoRepository.save(programacaoParaAtualizar);
    dispositivoService.enviaNotificacao(programacaoParaAtualizar);
  }

  @Override
  public Programacao busca(final String id) {
    return programacaoRepository.findOne(id);
  }

  public List<Programacao> pesquisa(final String titulo, final Status status) {
    return nonNull(status) ?
        programacaoRepository.findByTituloLikeAndStatusOrderByDataTerminoDesc(titulo, status) :
        programacaoRepository.findByTituloLikeOrderByDataTerminoDesc(titulo);
  }

  @Override
  public List<Programacao> pesquisa(final LocalDateTime versao) {
    return nonNull(versao) ?
        programacaoRepository.findByDataAtualizacaoAfter(versao) :
        programacaoRepository.findByStatus(Status.ATIVO);
  }

  @Override
  public List<Programacao> pesquisa(final LocalDateTime dataTermino, final Status status) {
   return programacaoRepository.findByDataTerminoBeforeAndStatus(dataTermino, status);
  }

  private void preparaParaSalvar(final Programacao programacao, final Programacao programacaoParaSalvar) {
    programacaoParaSalvar.setLocal(trimToNull(programacao.getLocal()));
    programacaoParaSalvar.setDescricao(trimToNull(programacao.getDescricao()));
    programacaoParaSalvar.setEndereco(trimToNull(programacao.getEndereco()));
    programacaoParaSalvar.setTitulo(trimToNull(programacao.getTitulo()));
    programacaoParaSalvar.setStatus(programacao.getStatus());
    programacaoParaSalvar.setTipo(programacao.getTipo());
    programacaoParaSalvar.setUrlBanner(trimToNull(programacao.getUrlBanner()));
    programacaoParaSalvar.setObservacao(trimToNull(programacao.getObservacao()));
    programacaoParaSalvar.setDataInicio(programacao.getDataInicio());
    programacaoParaSalvar.setDataTermino(programacao.getDataTermino());
  }
}