package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.TipoProgramacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProgramacaoRepository extends MongoRepository<TipoProgramacao, Integer> {

}
