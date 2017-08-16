package br.com.danielwisky.pibbaeta.models;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = TipoProgramacao.COLLECTION)
public class TipoProgramacao implements Serializable {

  public static final String COLLECTION = "tipoProgramacao";

  @Id
  private String id;
  @NotBlank
  private String descricao;
}
