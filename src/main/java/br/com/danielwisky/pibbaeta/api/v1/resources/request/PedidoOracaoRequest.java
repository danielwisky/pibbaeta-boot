package br.com.danielwisky.pibbaeta.api.v1.resources.request;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
public class PedidoOracaoRequest {

  @NotBlank
  private String nome;
  private String email;
  private String telefone;
  @NotBlank
  private String pedido;

  public PedidoOracao toModel() {
    PedidoOracao pedidoOracao = new PedidoOracao();
    pedidoOracao.setNome(getNome());
    pedidoOracao.setEmail(getEmail());
    pedidoOracao.setTelefone(getTelefone());
    pedidoOracao.setPedido(getPedido());
    return pedidoOracao;
  }
}