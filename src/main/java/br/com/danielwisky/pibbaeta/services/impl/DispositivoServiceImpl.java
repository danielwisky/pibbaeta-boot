package br.com.danielwisky.pibbaeta.services.impl;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.firebase.FirebaseSender;
import br.com.danielwisky.pibbaeta.firebase.Notificacao;
import br.com.danielwisky.pibbaeta.models.Dispositivo;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.repositories.DispositivoRepository;
import br.com.danielwisky.pibbaeta.services.DispositivoService;
import br.com.danielwisky.pibbaeta.services.FirebaseConfigService;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DispositivoServiceImpl implements DispositivoService {

  private DispositivoRepository dispositivoRepository;
  private FirebaseConfigService firebaseConfigService;

  @Async
  @Override
  public void adiciona(final Dispositivo dispositivo) {
    dispositivoRepository.insert(dispositivo);
  }

  @Override
  public List<Dispositivo> lista() {
    return dispositivoRepository.findAll();
  }

  @Async
  @Override
  public void enviaProgramacao(final Programacao programacao) {
    try {
      final FirebaseSender sender = new FirebaseSender(firebaseConfigService.getConfig());
      final AgendaResponse agendaResponse = new AgendaResponse(programacao);
      sender.enviar(agendaResponse);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

  @Async
  @Override
  public void enviaNotificacao(Notificacao notificacao) {
    try {
      final FirebaseSender sender = new FirebaseSender(firebaseConfigService.getConfig());
      sender.enviar(notificacao);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
}