package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacaoRepository extends MongoRepository<Programacao, String> {

  List<Programacao> findByTituloLikeOrderByDataTerminoDesc(String titulo);

  List<Programacao> findByTituloLikeAndStatusOrderByDataTerminoDesc(String titulo, Status status);

  List<Programacao> findByDataAtualizacaoAfter(LocalDateTime versao);

  List<Programacao> findByStatus(Status ativo);
}