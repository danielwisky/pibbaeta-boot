package br.com.danielwisky.pibbaeta.firebase;

import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import br.com.danielwisky.pibbaeta.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Slf4j
public class FirebaseClient {

  private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  protected OkHttpClient client = new OkHttpClient();

  private String URL;
  private String API_KEY;

  public FirebaseClient(FirebaseConfig config) {
    URL = config.getUrl();
    API_KEY = config.getApikey();
  }

  protected Request enviar(String json) {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
        .url(URL)
        .addHeader("Authorization", "key=" + API_KEY)
        .post(body)
        .build();
    return request;
  }

  public boolean validaAPIKey() {
    try {
      Request request = enviar(getJsonTeste());
      return client.newCall(request).execute().isSuccessful();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      return false;
    }
  }

  private String getJsonTeste() throws JsonProcessingException {
    return JsonUtils.toJson(new Mensagem("teste"));
  }
}