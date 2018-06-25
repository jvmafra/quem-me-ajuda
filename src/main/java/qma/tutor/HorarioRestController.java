package qma.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qma.aluno.Aluno;
import qma.aluno.AlunoService;
import qma.aluno.Local;

@RestController
@RequestMapping(value = "/")
public class HorarioRestController {
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "/horario", method=RequestMethod.GET, params= {"matricula", "dia", "hora"})
    public boolean getDisponbilidadeHorario(String matricula, String dia, String hora){
        return alunoService.getDisponibilidadeHorario(matricula, dia, hora);
    }
	
	@RequestMapping(value="/horario", method=RequestMethod.POST)
    public Aluno cadastraHorario(@RequestBody Horario horario){
        return alunoService.cadastraHorario(horario);
    }
	
	@RequestMapping(value = "/local", method=RequestMethod.GET, params= {"matricula", "local"})
    public boolean getDisponbilidadeLocal(String matricula, String local){
        return alunoService.getDisponibilidadeLocal(matricula, local);
    }
	
	@RequestMapping(value="/local", method=RequestMethod.POST)
    public Aluno cadastraLocal(@RequestBody Local local){
        return alunoService.cadastraLocal(local);
    }
	
	

}
