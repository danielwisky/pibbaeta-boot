package br.com.danielwisky.pibbaeta.firebase;

import br.com.danielwisky.pibbaeta.api.v1.resources.response.AgendaResponse;
import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class FirebaseSender extends FirebaseClient {

  private static final String TOPICS_AGENDA = "/topics/agenda";

  public FirebaseSender(FirebaseConfig config) {
    super(config);
  }

  public void enviar(AgendaResponse agendaResponse) throws IOException {

    Mensagem mensagem = new Mensagem();
    mensagem.put("message", agendaResponse);
    mensagem.setTo(TOPICS_AGENDA);

    String json = mapper.writeValueAsString(mensagem);
    Request request = enviar(json);
    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        log.info(response.message());
      }

      @Override
      public void onFailure(Call call, IOException e) {
        log.error(e.getMessage(), e);
      }
    });
  }
}
