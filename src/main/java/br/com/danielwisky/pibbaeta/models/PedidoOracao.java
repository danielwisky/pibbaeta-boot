package br.com.danielwisky.pibbaeta.models;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "pedidoOracao")
public class PedidoOracao {

  @Id
  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private String pedido;
  private LocalDateTime data;
}
