package qma.aluno;

import java.util.Map;

import qma.tutor.Horario;

public interface AlunoService {
	
	Aluno getByMatricula(String matricula);
	Aluno save(Aluno aluno);
	Iterable<Aluno> getAllAlunos();
	Aluno getTutorByMatricula(String matricula);
	Iterable<Aluno> getAllTutores();
	Aluno tornaTutor(Tutoria tutoria);
	Aluno cadastraHorario(Horario horario);
	boolean getDisponibilidadeHorario(String matricula, String dia, String hora);
	boolean getDisponibilidadeLocal(String matricula, String local);
	Aluno cadastraLocal(Local localDTO);
	Map<String, String> login(Aluno aluno);

}
