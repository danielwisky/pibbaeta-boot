package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.firebase.Notificacao;
import br.com.danielwisky.pibbaeta.models.Dispositivo;
import br.com.danielwisky.pibbaeta.models.Programacao;
import java.util.List;

public interface DispositivoService {

  void adiciona(Dispositivo dispositivo);

  List<Dispositivo> lista();

  void enviaProgramacao(Programacao programacao);

  void enviaNotificacao(Notificacao notificacao);
}