package qma.security;

import java.util.Optional;

import qma.aluno.Aluno;
import qma.aluno.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService implements UserDetailsService {

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public UserDetails loadUserByUsername(String matricula) {
    Optional<Aluno> optUser = alunoRepository.findById(matricula);

    if (!optUser.isPresent()) {
      throw new UsernameNotFoundException("User '" + matricula + "' not found");
    }

    Aluno aluno = optUser.get();

    return org.springframework.security.core.userdetails.User
          .withUsername(matricula)
          .password(aluno.getSenha())
          .authorities(aluno.getRoles())
          .accountExpired(false)
          .accountLocked(false)
          .credentialsExpired(false)
          .disabled(false)
          .build();
  }

}
