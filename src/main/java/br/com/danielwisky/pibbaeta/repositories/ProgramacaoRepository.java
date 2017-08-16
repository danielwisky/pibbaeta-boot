package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.Programacao;
import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacaoRepository extends MongoRepository<Programacao, String> {

  List<Programacao> findByTituloLike(String titulo);

  List<Programacao> findByTituloLikeAndStatus(String titulo, Status status);
}