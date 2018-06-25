package qma.ajuda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AjudaRepository {
	
	private Map<Long, Ajuda> ajudas = new HashMap<Long, Ajuda>();
	
	
	public Ajuda findById(Long id) {
		if (ajudas.get(id) != null) {
			return ajudas.get(id);
		}
		
		throw new RuntimeException("Ajuda nao encontrada");
	}
	
	public Ajuda save(Ajuda ajuda) {
		ajudas.put(ajuda.getId(), ajuda);
		return ajuda;
	}
	
	public Collection<Ajuda> findAll(){
		return ajudas.values();
	}

}
