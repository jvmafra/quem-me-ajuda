package qma.exceptions;

public class AlunoJaTutorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlunoJaTutorException() {
		super("O aluno ja eh tutor");
	}

}
