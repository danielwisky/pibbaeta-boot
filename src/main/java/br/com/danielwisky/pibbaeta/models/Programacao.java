package br.com.danielwisky.pibbaeta.models;

import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "programacao")
public class Programacao {

  @Id
  private Long id;
  private String titulo;
  private String descricao;
  private LocalDateTime dataInicio;
  private LocalDateTime dataTermino;
  private String local;
  private String endereco;
  private String urlBanner;
  private TipoProgramacao tipo;
  private LocalDateTime dataAtualizacao = LocalDateTime.now();
  private Status status = Status.ATIVO;
}
