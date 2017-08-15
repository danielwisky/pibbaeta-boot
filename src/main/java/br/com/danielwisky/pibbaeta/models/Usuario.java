package br.com.danielwisky.pibbaeta.models;

import br.com.danielwisky.pibbaeta.models.enums.Status;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = Usuario.COLLECTION)
public class Usuario implements UserDetails {

  public static final String COLLECTION = "usuario";

  @Id
  private String id;
  @NotBlank
  @Size(max = 80)
  private String nome;
  @NotBlank
  @Size(max = 20)
  private String login;
  @Email
  @NotBlank
  @Size(max = 160)
  private String email;
  @NotBlank
  private String senha;
  @Transient
  private String novaSenha;
  @Transient
  private String confirmarSenha;
  @Size(min = 1)
  private List<String> papeis;
  @NotNull
  private Status status = Status.ATIVO;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return papeis.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
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