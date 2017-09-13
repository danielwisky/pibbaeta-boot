package br.com.danielwisky.pibbaeta.api.v1.resources.request;

import br.com.danielwisky.pibbaeta.models.Feedback;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
public class FeedbackRequest {

  @NotBlank
  private String descricao;

  public Feedback toModel() {
    final Feedback feedback = new Feedback();
    feedback.setDescricao(getDescricao());
    return feedback;
  }
}