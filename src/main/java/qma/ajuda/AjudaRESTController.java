package qma.ajuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qma.aluno.Aluno;
import qma.aluno.AlunoService;

@RestController
@RequestMapping(value = "/")
public class AjudaRESTController {
	
	
	@Autowired
	AjudaService ajudaService;
	
	@RequestMapping(value = "/ajuda", method=RequestMethod.GET, params="id")
    public Ajuda getAjudaById(Long id){
        return ajudaService.getAjudaById(id);
    }
	
	@RequestMapping(value="/ajudaonline", method=RequestMethod.POST)
    public Ajuda pedeAjudaOnline(@RequestBody PedidoAjuda pedido){
        return ajudaService.pedeAjudaOnline(pedido);
    }
	
	@RequestMapping(value="/ajudapresencial", method=RequestMethod.POST)
    public Ajuda pedeAjudaPresencial(@RequestBody PedidoAjuda pedido){
        return ajudaService.pedeAjudaPresencial(pedido);
    }

}
