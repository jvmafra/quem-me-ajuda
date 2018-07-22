package qma.aluno;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
@Api(value = "Aluno Endpoint", description = "Operações relacionadas aos alunos")
public class AlunoRestController {
	
	@Autowired
	AlunoService alunoService;
	
	
	@ApiOperation(value = "Retorna todos os alunos cadastrados")
    @GetMapping
	@RequestMapping(value="/aluno", method=RequestMethod.GET)
    public Iterable<Aluno> getAlunos(){
        return alunoService.getAllAlunos();
    }
	
	@ApiOperation(value = "Cadastra um aluno no sistema")
    @GetMapping
	@RequestMapping(value="/signup", method=RequestMethod.POST)
    public Aluno save(@RequestBody Aluno aluno){
        return alunoService.save(aluno);
    }
	
	@ApiOperation(value = "Loga um aluno no sistema")
    @GetMapping
	@RequestMapping(value="/login", method = RequestMethod.POST,  headers="Content-Type=application/json")
	public Map<String,String> login(@RequestBody Aluno aluno) { 
		System.out.println(alunoService.login(aluno));
		return alunoService.login(aluno); }
	
	@ApiOperation(value = "Retorna um aluno pela sua matricula")
    @GetMapping
	@RequestMapping(value = "/aluno/{id}", method=RequestMethod.GET, params="matricula")
    public Aluno getAlunoByMatricula(String matricula){
        return alunoService.getByMatricula(matricula);
    }
	
	
	
	
	
	

}
