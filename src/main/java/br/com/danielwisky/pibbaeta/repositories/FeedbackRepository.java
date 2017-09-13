package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

}
