package qma.ajuda;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qma.aluno.Aluno;
import qma.aluno.AlunoRepository;
import qma.aluno.Local;
import qma.exceptions.AjudaNaoEncontradaException;
import qma.exceptions.SolicitanteNaoEncontradoException;
import qma.exceptions.TutorNaoEncontradoException;
import qma.tutor.DiaDaSemana;
import qma.tutor.Horario;

@Service
public class AjudaServiceImpl implements AjudaService{
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	AjudaRepository ajudaRepository;

	@Override
	public Ajuda getAjudaById(Long id) {
		Optional<Ajuda> optAjuda = ajudaRepository.findById(id);
		
		if (!optAjuda.isPresent()) {
			throw new AjudaNaoEncontradaException();
		}
		
		return optAjuda.get();
	}

	@Override
	public Ajuda pedeAjudaOnline(PedidoAjuda pedido) {
		
		Optional<Aluno> optAluno = alunoRepository.findById(pedido.getMatriculaAluno());
		
		if (!optAluno.isPresent()) {
			throw new SolicitanteNaoEncontradoException();
		}

		Aluno solicitante = optAluno.get();
		
		for (Aluno aluno: alunoRepository.findAll()) {
			
			if (isTutor(aluno.getMatricula())) {
				
				if (aluno.getTutoria().getDisciplina().equals(pedido.getDisciplina())) {
					Ajuda ajuda = new Ajuda(solicitante,
							aluno, pedido.getDisciplina());
					
					ajudaRepository.save(ajuda);
					return ajuda;
					
				}
			}
		}

		throw new RuntimeException("Nenhum tutor foi encontrado para essa disciplina");

	}

	@Override
	public Ajuda pedeAjudaPresencial(PedidoAjuda pedido) {
		Optional<Aluno> optAluno = alunoRepository.findById(pedido.getMatriculaAluno());
		
		if (!optAluno.isPresent()) {
			throw new RuntimeException("Aluno solicitante nao existe");
		}

		Aluno solicitante = optAluno.get();
		
		Horario horario = new Horario(DiaDaSemana.valueOf(pedido.getDia()), pedido.getHora());
		Local local = new Local(pedido.getLocal());
		
		for (Aluno aluno: alunoRepository.findAll()) {
			
			if (isTutor(aluno.getMatricula())) {
				
				if (aluno.getTutoria().getDisciplina().equals(pedido.getDisciplina()) &&
						aluno.getTutoria().getListaHorarios().contains(horario) &&
						aluno.getTutoria().getLocais().contains(local)) {
					
					Ajuda ajuda = new Ajuda(solicitante,
							aluno, pedido.getDisciplina(), pedido.getDia(), pedido.getHora(),
							pedido.getLocal());
					
					ajudaRepository.save(ajuda);
					return ajuda;
					
				}
			}
		}

		throw new RuntimeException("Nenhum tutor foi encontrado para essa disciplina, horario e local");
	}
	
	private boolean isTutor(String matricula) {
		
		Optional<Aluno> optUser = alunoRepository.findById(matricula);
		
		if (!optUser.isPresent()) {
			throw new TutorNaoEncontradoException();
		}
		
		Aluno aluno = optUser.get();
		
		if (aluno.getTutoria() != null) {
			return true;
		}
			
		return false;
	
	}

}
