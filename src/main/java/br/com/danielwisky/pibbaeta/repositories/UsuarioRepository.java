package br.com.danielwisky.pibbaeta.repositories;

import br.com.danielwisky.pibbaeta.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

  Usuario findByLogin(String login);

  boolean existsByLogin(String login);

  boolean existsByLoginAndIdNot(String login, String idUsuario);

  boolean existsByEmail(String email);

  boolean existsByEmailAndIdNot(String email, String id);
}
