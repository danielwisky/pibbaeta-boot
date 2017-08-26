package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.trimToNull;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import br.com.danielwisky.pibbaeta.repositories.PedidoOracaoRepository;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoOracaoServiceImpl implements PedidoOracaoService {

  private PedidoOracaoRepository pedidoOracaoRepository;

  @Async
  @Override
  public void adiciona(final PedidoOracao pedidoOracao) {
    preparaParaSalvar(pedidoOracao);
    pedidoOracaoRepository.insert(pedidoOracao);
  }

  @Override
  public List<PedidoOracao> lista() {
    return pedidoOracaoRepository.findAll(new Sort(Direction.DESC, "data"));
  }

  private void preparaParaSalvar(final PedidoOracao pedidoOracao) {
    pedidoOracao.setNome(trimToNull(pedidoOracao.getNome()));
    pedidoOracao.setEmail(trimToNull(pedidoOracao.getEmail()));
    pedidoOracao.setTelefone(trimToNull(pedidoOracao.getTelefone()));
    pedidoOracao.setPedido(trimToNull(pedidoOracao.getPedido()));
  }
}