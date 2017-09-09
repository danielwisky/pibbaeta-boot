package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.TipoProgramacao;
import java.util.List;

public interface TipoProgramacaoService {

  void adiciona(TipoProgramacao tipoProgramacao);

  void altera(TipoProgramacao tipoProgramacao, String id);

  List<TipoProgramacao> lista();

  TipoProgramacao busca(String id);
}