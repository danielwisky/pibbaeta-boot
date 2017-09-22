package br.com.danielwisky.pibbaeta.jobs;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.pibbaeta.firebase.Notificacao;
import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import br.com.danielwisky.pibbaeta.services.DispositivoService;
import br.com.danielwisky.pibbaeta.services.ProgramacaoService;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificacaoJob {

  private ProgramacaoService programacaoService;

  private DispositivoService dispositivoService;

  @Scheduled(cron = "*/10 * * * * *")
  public void execute() {
    final List<Programacao> programacoes = programacaoService.listaHoje();
    ofNullable(programacoes).ifPresent(programacaos -> {
      programacaos.forEach(programacao -> {
        final String titulo = String.format("Lembrete - %1s", programacao.getTitulo());
        final String corpo = programacao.getDataInicio().format(DateTimeFormatter.ofPattern("EEE, dd 'de' MMM 'às' HH:mm"));
        final Notificacao notificacao = new Notificacao(titulo, corpo);
        //dispositivoService.enviaNotificacao();
        log.info("notificacao - {}", notificacao);
      });
    });
  }
}