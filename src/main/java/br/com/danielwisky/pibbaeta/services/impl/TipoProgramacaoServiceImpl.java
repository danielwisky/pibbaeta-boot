package br.com.danielwisky.pibbaeta.services.impl;

import br.com.danielwisky.pibbaeta.models.TipoProgramacao;
import br.com.danielwisky.pibbaeta.repositories.TipoProgramacaoRepository;
import br.com.danielwisky.pibbaeta.services.TipoProgramacaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TipoProgramacaoServiceImpl implements TipoProgramacaoService {

  private TipoProgramacaoRepository tipoProgramacaoRepository;

  @Override
  public List<TipoProgramacao> lista() {
    return tipoProgramacaoRepository.findAll();
  }
}