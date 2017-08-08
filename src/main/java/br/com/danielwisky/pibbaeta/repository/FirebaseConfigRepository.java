package br.com.danielwisky.pibbaeta.repository;

import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirebaseConfigRepository extends MongoRepository<FirebaseConfig, Integer> {

}
