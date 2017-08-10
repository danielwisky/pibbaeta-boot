package br.com.danielwisky.pibbaeta.models;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = FirebaseConfig.COLLECTION)
public class FirebaseConfig implements Serializable {

  public static final String COLLECTION = "firebaseConfig";

  @Id
  private String id;
  private String url;
  private String apikey;
}
