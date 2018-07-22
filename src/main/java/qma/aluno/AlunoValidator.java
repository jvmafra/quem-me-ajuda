package qma.aluno;

import qma.exceptions.CodigoInvalidoException;
import qma.exceptions.EmailInvalidoException;
import qma.exceptions.MatriculaInvalidaException;
import qma.exceptions.NomeInvalidoException;
import qma.exceptions.SenhaInvalidaException;
import qma.exceptions.TelefoneInvalidoException;

public class AlunoValidator {
	
	public static void validaAluno(Aluno aluno) {
		
		if (aluno.getNome() == null || aluno.getNome().equals("")) {
			throw new NomeInvalidoException();
		} else if (aluno.getMatricula() == null || aluno.getMatricula().equals("")) {
			throw new MatriculaInvalidaException();
		} else if (aluno.getCodCurso() == null || aluno.getCodCurso().equals("")) {
			throw new CodigoInvalidoException();
		} else if (aluno.getTelefone() == null || aluno.getTelefone().equals("")) {
			throw new TelefoneInvalidoException();
		} else if (aluno.getEmail() == null || aluno.getEmail().equals("")) {
			throw new EmailInvalidoException();
		} else if (aluno.getSenha() == null || aluno.getSenha().equals("")) {
			throw new SenhaInvalidaException();
		}
		
	}

}
