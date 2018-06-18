package qma.tutor;

public interface TutorService {
	Tutor getByMatricula(String matricula);
	Tutor save(Tutor tutor);
	Iterable<Tutor> getAllTutores();
}
