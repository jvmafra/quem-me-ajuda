package qma.ajuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qma.aluno.Aluno;
import qma.aluno.AlunoRepository;

@Service
public class AjudaServiceImpl implements AjudaService{
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	AjudaRepository ajudaRepository;

	@Override
	public Ajuda getAjudaById(Long id) {
		return ajudaRepository.findById(id);
	}

	@Override
	public Ajuda pedeAjudaOnline(PedidoAjuda pedido) {
		
		Aluno tutor = alunoRepository.getTutorAjudaOnline(pedido);
		Ajuda ajuda = new Ajuda(alunoRepository.findById(pedido.getMatriculaAluno()),
					tutor, pedido.getDisciplina());
		
		ajudaRepository.save(ajuda);
		
		return ajuda;
		
	}

	@Override
	public Ajuda pedeAjudaPresencial(PedidoAjuda pedido) {
		Aluno tutor = alunoRepository.getTutorAjudaPresencial(pedido);
		Ajuda ajuda = new Ajuda(alunoRepository.findById(pedido.getMatriculaAluno()),
					tutor, pedido.getDisciplina(), pedido.getDia(), pedido.getHora(),
					pedido.getLocal());
		
		ajudaRepository.save(ajuda);
		
		return ajuda;
	}

}
