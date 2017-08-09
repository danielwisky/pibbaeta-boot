package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoOracaoRepository extends MongoRepository<PedidoOracao, Long> {

}
