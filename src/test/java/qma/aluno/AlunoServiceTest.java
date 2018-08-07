package qma.aluno;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import qma.QmaApplicationTests;
import qma.exceptions.AlunoJaTutorException;
import qma.exceptions.AlunoNaoEncontradoException;
import qma.exceptions.CodigoInvalidoException;
import qma.exceptions.EmailInvalidoException;
import qma.exceptions.LoginInvalidoException;
import qma.exceptions.MatriculaInvalidaException;
import qma.exceptions.NomeInvalidoException;
import qma.exceptions.SenhaInvalidaException;
import qma.exceptions.TelefoneInvalidoException;
import qma.exceptions.TutorNaoEncontradoException;
import qma.tutor.DiaDaSemana;
import qma.tutor.Horario;

public class AlunoServiceTest extends QmaApplicationTests{
	
	@Autowired
	private AlunoRepository alunoRepository;
	  
	 @Autowired
	private AlunoService alunoService;
	
	@Before
	public void setUp() {
		alunoService.save(new Aluno("123", "Joao", "123", "123", "123", "joao@ccc"));
	}
	
	@After
	public void afterTest() {
		alunoRepository.deleteAll();
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
	
	@Test(expected = LoginInvalidoException.class)
	public void testLoginSenhaInvalida() {
		alunoService.login((new Aluno("123", "joao", "1234", "123", "123", null)));
	}
	
	@Test(expected = LoginInvalidoException.class)
	public void testLoginMatriculaInvalida() {
		alunoService.login((new Aluno("1234", "joao", "123", "123", "123", null)));
	}
	
	@Test
	public void testLoginValido() {
		Map<String, String> result = alunoService.login((new Aluno("123", "joao", "123", "123", "123", null)));
		Assert.assertNotNull(result.get("token"));
		Assert.assertEquals(result.get("matricula"), "123");
	}
	
	@Test
	public void testGetAlunoByMatriculaValido() {
		Aluno aluno = alunoService.getByMatricula("123");
		Assert.assertNotNull(aluno);
		Assert.assertEquals(aluno.getNome(), "Joao");
		Assert.assertEquals(aluno.getMatricula(), "123");
	}
	
	@Test(expected = AlunoNaoEncontradoException.class)
	public void testGetAlunoByMatriculaInvalido() {
		alunoService.getByMatricula("1234");
	}
	
	@Test
	public void testGetAllAlunos() {
		Assert.assertEquals(alunoService.getAllAlunos().iterator().next(), new Aluno("123", "Joao", "123", "123", "123", "joao@ccc"));
	}
	
	@Test
	public void testGetAllTutores() {
		Assert.assertFalse(alunoService.getAllTutores().iterator().hasNext());
	}
	
	@Test(expected = AlunoNaoEncontradoException.class)
	public void testTornarTutorAlunoInexistente() {
		alunoService.tornaTutor(new Tutoria("1234", "Calculo", "10"));
	}
	
	@Test(expected = TutorNaoEncontradoException.class)
	public void testGetTutorInexistente() {
		alunoService.getTutorByMatricula("123");
	}
	
	@Test
	public void testTornarTutorAlunoExistente() {
		Aluno aluno = alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		Assert.assertEquals(aluno.getMatricula(), "123");
		Assert.assertNotNull(aluno.getTutoria());
		Assert.assertTrue(alunoService.getAllTutores().iterator().hasNext());
		Assert.assertEquals(aluno, alunoService.getTutorByMatricula("123"));
	}
	
	@Test(expected = AlunoJaTutorException.class)
	public void testTornarTutorAlunoJaTutor() {
		Aluno aluno = alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		Assert.assertEquals(aluno.getMatricula(), "123");
		Assert.assertNotNull(aluno.getTutoria());
		alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		
	}
	
	@Test
	public void testCadastraHorario() {
		Aluno aluno = alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		Assert.assertTrue(aluno.getTutoria().getListaHorarios().isEmpty());
		aluno = alunoService.cadastraHorario(new Horario("123", DiaDaSemana.SEGUNDA, "12:30"));
		Assert.assertFalse(aluno.getTutoria().getListaHorarios().isEmpty());
	}
	
	@Test
	public void testDisponibilidadeHorarioTrue() {
		alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		alunoService.cadastraHorario(new Horario("123", DiaDaSemana.SEGUNDA, "12:30"));
		
		Assert.assertTrue(alunoService.getDisponibilidadeHorario("123", "SEGUNDA", "12:30"));
	}
	
	@Test
	public void testDisponibilidadeHorarioFalse() {
		alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		alunoService.cadastraHorario(new Horario("123", DiaDaSemana.SEGUNDA, "12:30"));
		
		Assert.assertFalse(alunoService.getDisponibilidadeHorario("123", "SEGUNDA", "12:31"));
	}
	
	@Test
	public void testCadastraLocal() {
		Aluno aluno = alunoService.tornaTutor(new Tutoria("123", "Fisica", "10"));
		Assert.assertTrue(aluno.getTutoria().getLocais().isEmpty());
		aluno = alunoService.cadastraLocal(new Local("123", "CAA305"));
		Assert.assertFalse(aluno.getTutoria().getLocais().isEmpty());
	}
	
	@Test
	public void testDisponibilidadeLocalTrue() {
		alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		alunoService.cadastraLocal(new Local("123", "CAA305"));
		
		Assert.assertTrue(alunoService.getDisponibilidadeLocal("123", "CAA305"));
	}
	
	@Test
	public void testDisponibilidadeLocalFalse() {
		alunoService.tornaTutor(new Tutoria("123", "Calculo", "10"));
		alunoService.cadastraLocal(new Local("123", "CAA305"));
		
		Assert.assertFalse(alunoService.getDisponibilidadeLocal("123", "CAA304"));
	}
	
	
	
	
	
	

}
