package qma.aluno;

public interface AlunoService {
	
	Aluno getByMatricula(String matricula);
	Aluno save(Aluno aluno);
	Iterable<Aluno> getAllAlunos();
	String getInfoAluno(String matricula, String atributo);
	Aluno getTutorByMatricula(String matricula);
	Iterable<Aluno> getAllTutores();
	Aluno tornaTutor(Tutoria tutoria);

}
