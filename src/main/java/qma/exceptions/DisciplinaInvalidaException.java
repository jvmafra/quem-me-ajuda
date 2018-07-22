package qma.exceptions;

public class DisciplinaInvalidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DisciplinaInvalidaException() {
		super("Disciplina invalida");
	}

}
