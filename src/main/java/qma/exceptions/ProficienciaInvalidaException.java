package qma.exceptions;

public class ProficienciaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProficienciaInvalidaException() {
		super("Proficiencia invalida");
	}

}
