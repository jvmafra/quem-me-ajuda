package qma.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import qma.aluno.Aluno;
import qma.aluno.AlunoRepository;

import static java.util.Objects.isNull;
import javax.transaction.Transactional;

@Service
public class TutorServiceImpl implements TutorService{
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
//	@Autowired
//	PasswordEncoder passwordEnconder;

	@Override
	public Tutor getByMatricula(String matricula) {
		Tutor tutor = tutorRepository.findById(matricula).get();
		
		if (isNull(tutor)) {
			throw new RuntimeException("Tutor nao encontrado");
		}
		
		return tutor;
	}

	@Override
	@Transactional
	public Tutor save(Tutor tutor) {
		
		String matricula = tutor.getMatricula();
		
		try {
			alunoRepository.findById(matricula).get();
		} catch (Exception e) {
			throw new RuntimeException("Aluno nao existente");
		}
		
		//tutor.setSenha(passwordEnconder.encode(tutor.getSenha()));
		
		return tutorRepository.save(tutor);
	}

	@Override
	public Iterable<Tutor> getAllTutores() {
		return tutorRepository.findAll();
	}

}
