package br.com.danielwisky.pibbaeta.firebase;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import br.com.danielwisky.pibbaeta.utils.JsonUtils;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class FirebaseSender extends FirebaseClient {

  private static final String TOPICS_AGENDA = "/topics/agenda";
  private static final String TOPICS_NOTIFICACAO = "/topics/notificacao";

  public FirebaseSender(final FirebaseConfig config) {
    super(config);
  }

  public void enviar(final AgendaResponse agendaResponse) throws IOException {

    final Mensagem mensagem = new Mensagem();
    mensagem.putData("agendaResponse", agendaResponse);
    mensagem.setTo(TOPICS_AGENDA);

    final String json = JsonUtils.toJson(mensagem);
    final Request request = enviar(json);

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        log.info(response.message());
        response.close();
      }

      @Override
      public void onFailure(Call call, IOException e) {
        log.error(e.getMessage(), e);
      }
    });
  }

  public void enviar(final Notificacao notificacao) throws IOException {

    final Mensagem mensagem = new Mensagem();
    mensagem.setNotification(notificacao);
    mensagem.setTo(TOPICS_NOTIFICACAO);

    final String json = JsonUtils.toJson(mensagem);
    final Request request = enviar(json);

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        log.info(response.message());
        response.close();
      }

      @Override
      public void onFailure(Call call, IOException e) {
        log.error(e.getMessage(), e);
      }
    });
  }
}