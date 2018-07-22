package qma.exceptions;

public class CodigoInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CodigoInvalidoException() {
		super("Codigo de curso invalido");
	}

}