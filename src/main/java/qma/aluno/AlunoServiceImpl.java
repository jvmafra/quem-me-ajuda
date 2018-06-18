package qma.aluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;
import javax.transaction.Transactional;


@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
//	@Autowired
//	PasswordEncoder passwordEnconder;

	@Override
	public Aluno getByMatricula(String matricula) {
		
		Aluno aluno;
		try {
			aluno = alunoRepository.findById(matricula).get();
		} catch (Exception e) {
			throw new RuntimeException("Aluno nao encontrado");
		}
		
		return aluno;
	}

	@Override
	@Transactional
	public Aluno save(Aluno aluno) {
//		aluno.setSenha(passwordEnconder.encode(aluno.getSenha()));
		return alunoRepository.save(aluno);
	}

	@Override
	@Transactional
	public Iterable<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public String getInfoAluno(String matricula, String atributo) {
		Aluno aluno = getByMatricula(matricula);
		
		if (atributo == "Nome") {
			return aluno.getNome();
			
		} else if (atributo == "CodCurso") {
			return aluno.getCodCurso();
			
		} else if (atributo == "Telefone") {
			return aluno.getTelefone();
			
		} else if (atributo == "Email") {
			return aluno.getEmail();
			
		} else if (atributo == "Matricula") {
			return matricula;
			
		} else {
			throw new RuntimeException("Atributo nao encontrado");
		}
	}

}