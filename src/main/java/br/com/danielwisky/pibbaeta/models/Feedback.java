package br.com.danielwisky.pibbaeta.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Feedback.COLLECTION)
public class Feedback implements Serializable {

  public static final String COLLECTION = "feedback";

  @Id
  private String id;
  @NotBlank
  private String descricao;
  @LastModifiedDate
  private LocalDateTime data;
}
