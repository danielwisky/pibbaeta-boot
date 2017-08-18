package br.com.danielwisky.pibbaeta.firebase;

import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import java.io.IOException;

public class FirebaseSender extends FirebaseClient {

  public FirebaseSender(FirebaseConfig config) throws IOException {
    super(config);
  }
}
