package br.com.danielwisky.pibbaeta.services.impl;

import br.com.danielwisky.pibbaeta.models.Dispositivo;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.repositories.DispositivoRepository;
import br.com.danielwisky.pibbaeta.services.DispositivoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DispositivoServiceImpl implements DispositivoService {

  private DispositivoRepository dispositivoRepository;

  @Async
  @Override
  public void adiciona(Dispositivo dispositivo) {
    dispositivoRepository.insert(dispositivo);
  }

  @Override
  public List<Dispositivo> lista() {
    return dispositivoRepository.findAll();
  }

  @Async
  @Override
  public void enviaNotificacao(Programacao programacao) {


  }
}