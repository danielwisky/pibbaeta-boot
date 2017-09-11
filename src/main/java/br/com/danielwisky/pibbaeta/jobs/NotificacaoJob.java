package br.com.danielwisky.pibbaeta.jobs;

import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificacaoJob {

  private ProgramacaoService programacaoService;

  @Scheduled(cron = "0 0 10 * * *")
  public void execute() {

  }
}