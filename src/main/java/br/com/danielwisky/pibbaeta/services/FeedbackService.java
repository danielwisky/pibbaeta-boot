package br.com.danielwisky.pibbaeta.services;

import br.com.danielwisky.pibbaeta.models.Feedback;
import java.util.List;

public interface FeedbackService {

  void adiciona(Feedback feedback);

  List<Feedback> lista();
}
