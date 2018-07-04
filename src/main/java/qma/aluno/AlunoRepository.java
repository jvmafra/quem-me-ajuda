package qma.aluno;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface AlunoRepository extends CrudRepository<Aluno, String> {
	
}

