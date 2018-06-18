package qma.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TutorRestController {
	
	@Autowired
	TutorService tutorService;
	
	@RequestMapping(value = "/tutor", method=RequestMethod.GET, params="matricula")
    public Tutor getAlunoByMatricula(String matricula){
        return tutorService.getByMatricula(matricula);
    }
	
	@RequestMapping(value="/tutor", method=RequestMethod.GET)
    public Iterable<Tutor> getAlunos(){
        return tutorService.getAllTutores();
    }
	
	@RequestMapping(value="/tutor", method=RequestMethod.POST)
    public Tutor save(@RequestBody Tutor tutor){
        return tutorService.save(tutor);
    }

}
