package br.com.danielwisky.pibbaeta.services.impl;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.pibbaeta.firebase.FirebaseClient;
import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import br.com.danielwisky.pibbaeta.repositories.FirebaseConfigRepository;
import br.com.danielwisky.pibbaeta.services.FirebaseConfigService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirebaseConfigServiceImpl implements FirebaseConfigService {

  private FirebaseConfigRepository firebaseConfigRepository;

  @Override
  public void salva(final FirebaseConfig firebaseConfig) {
    firebaseConfigRepository.save(firebaseConfig);
  }

  @Override
  public boolean tokenValido() {
    return new FirebaseClient(getConfig()).validaAPIKey();
  }

  @Override
  public FirebaseConfig getConfig() {
    return ofNullable(firebaseConfigRepository.findByIdIsNotNull())
        .orElse(new FirebaseConfig(null, "https://fcm.googleapis.com/fcm/send", ""));
  }
}