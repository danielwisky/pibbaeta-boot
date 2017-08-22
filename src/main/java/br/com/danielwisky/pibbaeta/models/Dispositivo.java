package br.com.danielwisky.pibbaeta.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Dispositivo.COLLECTION)
public class Dispositivo  {

  public static final String COLLECTION = "dispositivo";

  @Id
  private String id;
  @NotBlank
  private String token;
}