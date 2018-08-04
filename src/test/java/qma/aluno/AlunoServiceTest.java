package qma.aluno;

import org.junit.Before;
import org.junit.Test;

import qma.exceptions.CodigoInvalidoException;
import qma.exceptions.EmailInvalidoException;
import qma.exceptions.MatriculaInvalidaException;
import qma.exceptions.NomeInvalidoException;
import qma.exceptions.SenhaInvalidaException;
import qma.exceptions.TelefoneInvalidoException;

public class AlunoServiceTest {
	
	AlunoService alunoService;
	
	@Before
	public void setUp() {
		alunoService = new AlunoServiceImpl();
	}
	
	@Test(expected = NomeInvalidoException.class)
	public void testCadastroNomeVazio() {
		alunoService.save(new Aluno("123", "", "123", "123", "123", "joao@ccc"));
	}
	
	@Test(expected = NomeInvalidoException.class)
	public void testCadastroNomeNulo() {
		alunoService.save(new Aluno("123", null, "123", "123", "123", "joao@ccc"));
	}
	
	@Test(expected = MatriculaInvalidaException.class)
	public void testCadastroMatriculaVazia() {
		alunoService.save(new Aluno("", "joao", "123", "123", "123", "joao@ccc"));
	}
	
	@Test(expected = MatriculaInvalidaException.class)
	public void testCadastroMatriculaNula() {
		alunoService.save(new Aluno(null, "joao", "123", "123", "123", "joao@ccc"));
	}
	
	@Test(expected = SenhaInvalidaException.class)
	public void testCadastroSenhaVazia() {
		alunoService.save(new Aluno("123", "joao", "", "123", "123", "joao@ccc"));
	}
	
	@Test(expected = SenhaInvalidaException.class)
	public void testCadastroSenhaNula() {
		alunoService.save(new Aluno("123", "joao", null, "123", "123", "joao@ccc"));
	}
	
	@Test(expected = CodigoInvalidoException.class)
	public void testCadastroCodigoVazio() {
		alunoService.save(new Aluno("123", "joao", "123", "", "123", "joao@ccc"));
	}
	
	@Test(expected = TelefoneInvalidoException.class)
	public void testCadastroTelefoneVazio() {
		alunoService.save(new Aluno("123", "joao", "123", "123", "", "joao@ccc"));
	}
	
	@Test(expected = TelefoneInvalidoException.class)
	public void testCadastroTelefoneNulo() {
		alunoService.save(new Aluno("123", "joao", "123", "123", null, "joao@ccc"));
	}
	
	@Test(expected = EmailInvalidoException.class)
	public void testCadastroEmailVazio() {
		alunoService.save(new Aluno("123", "joao", "123", "123", "123", ""));
	}
	
	@Test(expected = EmailInvalidoException.class)
	public void testCadastroEmailNulo() {
		alunoService.save(new Aluno("123", "joao", "123", "123", "123", null));
	}
	
	
	
	
	

}
