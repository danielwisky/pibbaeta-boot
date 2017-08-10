package br.com.danielwisky.pibbaeta.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Papel.COLLECTION)
public class Papel implements GrantedAuthority {

  public static final String COLLECTION = "papel";

  @Id
  private String id;
  private String descricao;

  @Override
  public String getAuthority() {
    return this.descricao;
  }
}