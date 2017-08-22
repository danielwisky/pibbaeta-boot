package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.Dispositivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends MongoRepository<Dispositivo, String> {

}