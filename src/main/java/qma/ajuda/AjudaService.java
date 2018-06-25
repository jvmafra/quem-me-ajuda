package qma.ajuda;

public interface AjudaService {
	
	Ajuda getAjudaById(Long id);
	Ajuda pedeAjudaOnline(PedidoAjuda pedido);
	Ajuda pedeAjudaPresencial(PedidoAjuda pedido);
}
