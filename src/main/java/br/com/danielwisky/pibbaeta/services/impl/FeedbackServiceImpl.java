package br.com.danielwisky.pibbaeta.services.impl;

import static org.apache.commons.lang3.StringUtils.trimToNull;

import br.com.danielwisky.pibbaeta.models.Feedback;
import br.com.danielwisky.pibbaeta.repositories.FeedbackRepository;
import br.com.danielwisky.pibbaeta.services.FeedbackService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

  private FeedbackRepository feedbackRepository;

  @Async
  @Override
  public void adiciona(final Feedback feedback) {
    preparaParaSalvar(feedback);
    feedbackRepository.insert(feedback);
  }

  @Override
  public List<Feedback> lista() {
    return feedbackRepository.findAll(new Sort(Direction.DESC, "data"));
  }

  private void preparaParaSalvar(final Feedback feedback) {
    feedback.setDescricao(trimToNull(feedback.getDescricao()));
  }
}