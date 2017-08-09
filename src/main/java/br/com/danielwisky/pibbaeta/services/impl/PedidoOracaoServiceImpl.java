package br.com.danielwisky.pibbaeta.services.impl;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import br.com.danielwisky.pibbaeta.repositories.PedidoOracaoRepository;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoOracaoServiceImpl implements PedidoOracaoService {

  private PedidoOracaoRepository pedidoOracaoRepository;

  @Async
  @Override
  public void adiciona(PedidoOracao pedidoOracao) {
    preparaParaSalvar(pedidoOracao);
    pedidoOracaoRepository.insert(pedidoOracao);
  }

  private void preparaParaSalvar(PedidoOracao pedidoOracao) {
    pedidoOracao.setNome(trimToNull(pedidoOracao.getNome()));
    pedidoOracao.setEmail(trimToNull(pedidoOracao.getEmail()));
    pedidoOracao.setTelefone(trimToNull(pedidoOracao.getTelefone()));
    pedidoOracao.setPedido(trimToNull(pedidoOracao.getPedido()));
    pedidoOracao.setData(now());
  }
}