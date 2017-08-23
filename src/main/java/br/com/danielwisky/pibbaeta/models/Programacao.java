package br.com.danielwisky.pibbaeta.models;

import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Programacao.COLLECTION)
public class Programacao implements Serializable {

  public static final String COLLECTION = "programacao";

  @Id
  private String id;
  @NotBlank
  private String titulo;
  @NotBlank
  private String descricao;
  @NotNull
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dataInicio;
  @NotNull
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dataTermino;
  @NotBlank
  private String local;
  private String endereco;
  private String urlBanner;
  @NotNull
  private Tipo tipo;
  private String observacao;
  private LocalDateTime dataAtualizacao;
  @NotNull
  private Status status = Status.ATIVO;
}