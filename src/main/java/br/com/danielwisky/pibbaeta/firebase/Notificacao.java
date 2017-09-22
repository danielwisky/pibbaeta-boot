package br.com.danielwisky.pibbaeta.firebase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {

  private String title;
  private String body;
}