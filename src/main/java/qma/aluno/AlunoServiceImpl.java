package qma.aluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import qma.tutor.DiaDaSemana;
import qma.tutor.Horario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
//	@Autowired
//	PasswordEncoder passwordEnconder;

	@Override
	public Aluno getByMatricula(String matricula) {
		Optional<Aluno> optUser = alunoRepository.findById(matricula);
		
		if (!optUser.isPresent()) {
			throw new RuntimeException("Aluno nao encontrado");
		}
		
		return optUser.get();
	}

	@Override
	@Transactional
	public Aluno save(Aluno aluno) {
//		aluno.setSenha(passwordEnconder.encode(aluno.getSenha()));
		return alunoRepository.save(aluno);
	}

	@Override
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
	
	@Override
	public Aluno getTutorByMatricula(String matricula) {
		Aluno aluno = getByMatricula(matricula);
		if (aluno.getTutoria() != null) {
			return aluno;
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}

	@Override
	public Iterable<Aluno> getAllTutores() {
		
		List<Aluno> tutores = new ArrayList<>();
		Iterable<Aluno> alunos = getAllAlunos();
		
		for (Aluno aluno: alunos) {
			if (aluno.getTutoria() != null) {
				tutores.add(aluno);
			}
		}
		
		return tutores;
		
	}

	@Override
	@Transactional
	public Aluno tornaTutor(Tutoria tutoria) {
		Aluno aluno = getByMatricula(tutoria.getMatricula());
		
		if (aluno.getTutoria() != null) {
			throw new RuntimeException("O aluno ja eh tutor");
		}
		
		aluno.tornarTutor(tutoria);
		return aluno;
	}

	@Override
	@Transactional
	public Aluno cadastraHorario(Horario horario) {
		String matricula = horario.getMatricula();
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);
			aluno.getTutoria().adicionaHorario(horario);
			return aluno;
		}
		
		throw new RuntimeException("Tutor nao encontrado");	
	}

	@Override
	public boolean getDisponibilidadeHorario(String matricula, String dia, String hora) {
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);
			Horario tempHorario = new Horario(DiaDaSemana.valueOf(dia), hora);
			return aluno.getTutoria().getListaHorarios().contains(tempHorario);
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}

	@Override
	public boolean getDisponibilidadeLocal(String matricula, String local) {
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);	
			return aluno.getTutoria().getLocais().contains(new Local(local));
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}

	@Override
	@Transactional
	public Aluno cadastraLocal(Local local) {
		if (isTutor(local.getMatricula())) {
			Aluno aluno = getByMatricula(local.getMatricula());
			aluno.getTutoria().adicionaLocal(local);
			return aluno;
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}
	
	
	public boolean isTutor(String matricula) {
	
		Aluno aluno = getByMatricula(matricula);
		System.out.println(aluno.getTutoria());
		if (aluno.getTutoria() != null) {
			return true;
		}
			
		return false;
	
	}

}
