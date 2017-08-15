package br.com.danielwisky.pibbaeta.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = FirebaseConfig.COLLECTION)
@AllArgsConstructor
@NoArgsConstructor
public class FirebaseConfig implements Serializable {

  public static final String COLLECTION = "firebaseConfig";

  @Id
  private String id;
  @NotBlank
  private String url;
  @NotBlank
  private String apikey;
}