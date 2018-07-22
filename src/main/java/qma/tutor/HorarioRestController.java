package qma.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import qma.aluno.Aluno;
import qma.aluno.AlunoService;
import qma.aluno.Local;

@RestController
@RequestMapping(value = "/")
@Api(value = "Horario Endpoint", description = "Operações relacionadas aos horarios de um tutor")
public class HorarioRestController {
	
	@Autowired
	AlunoService alunoService;
	
	@ApiOperation(value = "Retorna se um tutor está disponível para atender em determinado local, dia e hora")
    @GetMapping
	@RequestMapping(value = "/horario", method=RequestMethod.GET, params= {"matricula", "dia", "hora"})
    public boolean getDisponbilidadeHorario(String matricula, String dia, String hora){
        return alunoService.getDisponibilidadeHorario(matricula, dia, hora);
    }
	
	@ApiOperation(value = "Cadastra novo horario de um tutor")
    @GetMapping
	@RequestMapping(value="/horario", method=RequestMethod.POST)
    public Aluno cadastraHorario(@RequestBody Horario horario){
        return alunoService.cadastraHorario(horario);
    }
	
	@ApiOperation(value = "Retorna se um tutor está disponível para atender em determinado local")
    @GetMapping
	@RequestMapping(value = "/local", method=RequestMethod.GET, params= {"matricula", "local"})
    public boolean getDisponbilidadeLocal(String matricula, String local){
        return alunoService.getDisponibilidadeLocal(matricula, local);
    }
	
	@ApiOperation(value = "Cadastra novo local de atendimento para um tutor")
    @GetMapping
	@RequestMapping(value="/local", method=RequestMethod.POST)
    public Aluno cadastraLocal(@RequestBody Local local){
        return alunoService.cadastraLocal(local);
    }
	
	

}
