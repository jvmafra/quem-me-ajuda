package qma.exceptions;

public class TelefoneInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TelefoneInvalidoException() {
		super("Telefone invalido");
	}

}
