package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Dispositivo;
import java.util.List;

public interface DispositivoService {

  void adiciona(Dispositivo dispositivo);

  List<Dispositivo> lista();
}