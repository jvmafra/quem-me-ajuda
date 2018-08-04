package qma.aluno;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface AlunoRepository extends JpaRepository<Aluno, String> {
	
}

