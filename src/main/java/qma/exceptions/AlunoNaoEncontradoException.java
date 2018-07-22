package qma.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontradoException() {
		super("Aluno nao encontrado");
	}
	
	public AlunoNaoEncontradoException(String message) {
		super(message);
	}

}