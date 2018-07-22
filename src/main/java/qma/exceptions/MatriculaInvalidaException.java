package qma.exceptions;

public class MatriculaInvalidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MatriculaInvalidaException() {
		super("Matricula invalida");
	}

}
