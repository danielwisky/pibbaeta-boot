package br.com.danielwisky.pibbaeta.models;

import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Usuario.COLLECTION)
public class Usuario implements UserDetails {

  public static final String COLLECTION = "usuario";

  @Id
  private String id;
  private String nome;
  private String login;
  private String email;
  private String senha;
  private String novaSenha;
  private String confirmarSenha;
  private List<Papel> papeis = new ArrayList<Papel>();
  private Status status = Status.ATIVO;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.papeis;
  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    return this.login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return Status.ATIVO.equals(this.status);
  }
}