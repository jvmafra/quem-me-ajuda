package qma.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class AlunoRestController {
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
    public String helloWorld(){
        return "Hello, World!";
    }
	
	@RequestMapping(value = "/aluno", method=RequestMethod.GET, params="matricula")
    public Aluno getAlunoByMatricula(String matricula){
        return alunoService.getByMatricula(matricula);
    }
	
	@RequestMapping(value="/aluno", method=RequestMethod.GET)
    public Iterable<Aluno> getAlunos(){
        return alunoService.getAllAlunos();
    }
	
	@RequestMapping(value="/aluno/signup", method=RequestMethod.POST)
    public Aluno save(@RequestBody Aluno aluno){
        return alunoService.save(aluno);
    }
	
	@RequestMapping(value="/aluno/login", method = RequestMethod.POST,  headers="Content-Type=application/json")
	public String login(@RequestBody Aluno aluno) { return alunoService.login(aluno); }
	
	
	
	

}
