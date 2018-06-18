package qma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
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
	
	@RequestMapping(value="/aluno", method=RequestMethod.POST)
    public Aluno save(@RequestBody Aluno aluno){
        return alunoService.save(aluno);
    }
	
	
	
	

}
