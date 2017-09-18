package br.com.danielwisky.pibbaeta.jobs;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class InativacaoJob {

  private ProgramacaoService programacaoService;

  @Scheduled(cron = "0 0 6 * * *")
  public void execute() {
    final List<Programacao> programacoes = programacaoService.pesquisa(LocalDateTime.now(), Status.ATIVO);
    ofNullable(programacoes).ifPresent(programacaos -> {
      programacaos.forEach(programacao -> {
        log.info("inativando programação - {}", programacao);
        programacao.setStatus(Status.INATIVO);
        programacaoService.altera(programacao);
      });
    });
  }
}