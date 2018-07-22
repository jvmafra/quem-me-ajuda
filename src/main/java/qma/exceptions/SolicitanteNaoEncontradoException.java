package qma.exceptions;

public class SolicitanteNaoEncontradoException extends AlunoNaoEncontradoException{

	private static final long serialVersionUID = 1L;
	
	public SolicitanteNaoEncontradoException() {
		super("Aluno solicitante nao encontrado");
	}

}
