package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import java.util.List;

public interface PedidoOracaoService {

  void adiciona(PedidoOracao pedidoOracao);

  List<PedidoOracao> lista();
}
