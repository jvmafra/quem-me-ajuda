package qma.aluno;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ALUNO, ROLE_TUTOR;

  public String getAuthority() {
    return name();
  }
}
