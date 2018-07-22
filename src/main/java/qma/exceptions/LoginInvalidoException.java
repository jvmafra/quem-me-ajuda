package qma.exceptions;

public class LoginInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoginInvalidoException() {
		super("Usuario ou senha invalidos");
	}

}
