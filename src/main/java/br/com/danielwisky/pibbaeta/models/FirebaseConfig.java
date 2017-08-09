package br.com.danielwisky.pibbaeta.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "firebaseConfig")
public class FirebaseConfig {

  @Id
  private String id;
  private String url;
  private String apikey;
}
