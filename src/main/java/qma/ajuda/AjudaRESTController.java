package qma.ajuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/")
@Api(value = "Ajuda Endpoint", description = "Operações relacionadas às ajudas fornecidas pelos tutores")
public class AjudaRESTController {
	
	
	@Autowired
	AjudaService ajudaService;
	
	@ApiOperation(value = "Retorna uma determinada ajuda pelo seu id")
    @GetMapping
	@RequestMapping(value = "/ajuda", method=RequestMethod.GET, params="id")
    public Ajuda getAjudaById(Long id){
        return ajudaService.getAjudaById(id);
    }
	
	@ApiOperation(value = "Faz um pedido de ajuda online")
    @GetMapping
	@RequestMapping(value="/ajudaonline", method=RequestMethod.POST)
    public Ajuda pedeAjudaOnline(@RequestBody PedidoAjuda pedido){
        return ajudaService.pedeAjudaOnline(pedido);
    }
	
	@ApiOperation(value = "Faz um pedido de ajuda presencial")
    @GetMapping
	@RequestMapping(value="/ajudapresencial", method=RequestMethod.POST)
    public Ajuda pedeAjudaPresencial(@RequestBody PedidoAjuda pedido){
        return ajudaService.pedeAjudaPresencial(pedido);
    }

}
