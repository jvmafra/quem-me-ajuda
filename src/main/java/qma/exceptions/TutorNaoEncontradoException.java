package qma.exceptions;

public class TutorNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TutorNaoEncontradoException() {
		super("Tutor nao encontrado");
	}

}