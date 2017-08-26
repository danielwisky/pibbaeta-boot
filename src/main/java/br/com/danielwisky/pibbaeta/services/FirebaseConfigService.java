package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import java.io.IOException;

public interface FirebaseConfigService {

  void salva(FirebaseConfig firebaseConfig);

  boolean tokenValido();

  FirebaseConfig getConfig();
}