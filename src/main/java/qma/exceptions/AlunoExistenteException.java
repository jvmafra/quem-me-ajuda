package qma.exceptions;

public class AlunoExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AlunoExistenteException() {
		super("Aluno ja existente");
	}

}
