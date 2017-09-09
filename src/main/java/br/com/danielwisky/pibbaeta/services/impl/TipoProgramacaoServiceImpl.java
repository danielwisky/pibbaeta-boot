package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.trimToNull;

import br.com.danielwisky.pibbaeta.models.TipoProgramacao;
import br.com.danielwisky.pibbaeta.repositories.TipoProgramacaoRepository;
import br.com.danielwisky.pibbaeta.services.TipoProgramacaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TipoProgramacaoServiceImpl implements TipoProgramacaoService {

  private TipoProgramacaoRepository tipoProgramacaoRepository;

  @Override
  public void adiciona(final TipoProgramacao tipoProgramacao) {
    preparaParaSalvar(tipoProgramacao, tipoProgramacao);
    tipoProgramacaoRepository.insert(tipoProgramacao);
  }

  @Override
  public void altera(final TipoProgramacao tipoProgramacao, final String id) {
    TipoProgramacao tipoParaAtualizar = tipoProgramacaoRepository.findOne(id);
    preparaParaSalvar(tipoProgramacao, tipoParaAtualizar);
    tipoProgramacaoRepository.save(tipoParaAtualizar);
  }

  @Override
  public List<TipoProgramacao> lista() {
    return tipoProgramacaoRepository.findAll(new Sort(Direction.ASC, "descricao"));
  }

  @Override
  public TipoProgramacao busca(final String id) {
    return tipoProgramacaoRepository.findOne(id);
  }

  private void preparaParaSalvar(
      final TipoProgramacao tipoProgramacao,
      final TipoProgramacao tipoProgramacaoParaSalvar) {
    tipoProgramacaoParaSalvar.setDescricao(trimToNull(tipoProgramacao.getDescricao()));
  }
}