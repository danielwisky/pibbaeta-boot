package br.com.danielwisky.pibbaeta.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "tipoProgramacao")
public class TipoProgramacao {

  @Id
  private Integer id;
  private String descricao;
}
