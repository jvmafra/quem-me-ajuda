package qma.exceptions;

public class EmailInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmailInvalidoException() {
		super("Email invalido");
	}

}
