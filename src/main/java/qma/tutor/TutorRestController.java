package qma.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qma.aluno.Aluno;
import qma.aluno.AlunoService;
import qma.aluno.Tutoria;

@RestController
@RequestMapping(value = "/")
public class TutorRestController {
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "tutor", method=RequestMethod.GET, params="matricula")
    public Aluno getTutorByMatricula(String matricula){
        return alunoService.getTutorByMatricula(matricula);
    }
	
	@RequestMapping(value="tutor", method=RequestMethod.GET)
    public Iterable<Aluno> getAlunos(){
        return alunoService.getAllTutores();
    }
	
	@RequestMapping(value="tutor", method=RequestMethod.POST)
    public Aluno tornarTutor(@RequestBody Tutoria tutoria){
        return alunoService.tornaTutor(tutoria);
    }

}
