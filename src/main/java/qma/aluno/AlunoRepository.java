package qma.aluno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import qma.tutor.DiaDaSemana;
import qma.tutor.Horario;

@Repository
@Transactional
public class AlunoRepository{
	
	private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
	
	public Aluno findById(String matricula) {
		if (alunos.get(matricula) != null) {
			return alunos.get(matricula);
		}
		
		throw new RuntimeException("Aluno nao encontrado");
	}
	
	public Aluno save(Aluno aluno) {
		alunos.put(aluno.getMatricula(), aluno);
		return aluno;
	}
	
	public Collection<Aluno> findAll(){
		return alunos.values();
	}

	public Aluno getTutorByMatricula(String matricula) {
		if (alunos.get(matricula) != null && alunos.get(matricula).getTutoria() != null) {
			return alunos.get(matricula);
		}
		throw new RuntimeException("Tutor nao encontrado");
		
	}

	public Iterable<Aluno> getAllTutores() {
		List<Aluno> tutores = new ArrayList<>();
		
		for (Aluno aluno: alunos.values()) {
			if (aluno.getTutoria() != null) {
				tutores.add(aluno);
			}
		}
		
		return tutores;
		
	}
	
	@Transactional
	public Aluno tornarTutor(Tutoria tutoria) {
		String matricula = tutoria.getMatricula();
		
		if (alunos.containsKey(matricula)) {
			
			Aluno aluno = alunos.get(matricula);
			
			if (aluno.getTutoria() == null) {
				alunos.get(matricula).tornarTutor(tutoria);
			} else {
				throw new RuntimeException("O aluno ja eh tutor");
			}
			
			return aluno;
			
		}
		
		throw new RuntimeException("Aluno nao encontrado");
	}

	public Aluno cadastraHorario(Horario horario) {
		String matricula = horario.getMatricula();
		
		if (isTutor(matricula)) {
			Aluno aluno = alunos.get(matricula);
			aluno.getTutoria().adicionaHorario(horario);
			return aluno;
		}
		
		throw new RuntimeException("Tutor nao encontrado");	
		

	}

	public boolean getDisponibilidadeHorario(String matricula, String dia, String hora) {
		
		if (isTutor(matricula)) {
			Aluno aluno = alunos.get(matricula);
			Horario tempHorario = new Horario(DiaDaSemana.valueOf(dia), hora);
			return aluno.getTutoria().getListaHorarios().contains(tempHorario);
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}

	public boolean getDisponibilidadeLocal(String matricula, String local) {
		if (isTutor(matricula)) {
			Aluno aluno = alunos.get(matricula);
			return aluno.getTutoria().getLocais().contains(new Local(matricula, local));
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}
	
	
	public Aluno cadastraLocal(Local local) {
		if (isTutor(local.getMatricula())) {
			Aluno aluno = alunos.get(local.getMatricula());
			aluno.getTutoria().adicionaLocal(local);
			return aluno;
		}
		
		throw new RuntimeException("Tutor nao encontrado");
	}
	
	
	private boolean isTutor(String matricula) {
		
		if (alunos.containsKey(matricula)) {
			
			Aluno aluno = alunos.get(matricula);
			
			if (aluno.getTutoria() != null) 
				return true;
			
		}
		
		return false;
		
	}
	
	
}

