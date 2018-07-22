package qma.exceptions;

public class AjudaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AjudaNaoEncontradaException() {
		super("Ajuda nao encontrada");
	}

}
