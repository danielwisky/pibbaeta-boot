package br.com.danielwisky.pibbaeta.firebase;

import static java.util.Collections.unmodifiableMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_EMPTY)
public class Mensagem {

  private final Map<String, Object> data = new HashMap<>();
  private Notificacao notification;
  private String to;

  public Mensagem() {
    super();
  }

  public Mensagem(String to) {
    super();
    this.to = to;
  }

  public Map<String, Object> getData() {
    return unmodifiableMap(data);
  }

  public void putData(String key, Object value) {
    data.put(key, value);
  }

  public Notificacao getNotification() {
    return notification;
  }

  public void setNotification(Notificacao notification) {
    this.notification = notification;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }
}