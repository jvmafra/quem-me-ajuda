package qma.aluno;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface AlunoRepository extends CrudRepository<Aluno, String> {
	
	//Optional<Aluno> findByMatricula (String matricula);
	
//	private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
//	
//	public Aluno findById(String matricula) {
//		if (alunos.get(matricula) != null) {
//			return alunos.get(matricula);
//		}
//		
//		throw new RuntimeException("Aluno nao encontrado");
//	}
//	
//	public Aluno save(Aluno aluno) {
//		if (alunos.containsKey(aluno.getMatricula())) {
//			throw new RuntimeException("Aluno ja existente");
//		}
//		alunos.put(aluno.getMatricula(), aluno);
//		return aluno;
//	}
//	
//	public Collection<Aluno> findAll(){
//		return alunos.values();
//	}
//
//	public Aluno getTutorByMatricula(String matricula) {
//		if (alunos.get(matricula) != null && alunos.get(matricula).getTutoria() != null) {
//			return alunos.get(matricula);
//		}
//		throw new RuntimeException("Tutor nao encontrado");
//		
//	}
//
//	public Iterable<Aluno> getAllTutores() {
//		List<Aluno> tutores = new ArrayList<>();
//		
//		for (Aluno aluno: alunos.values()) {
//			if (aluno.getTutoria() != null) {
//				tutores.add(aluno);
//			}
//		}
//		
//		return tutores;
//		
//	}
//	
//	@Transactional
//	public Aluno tornarTutor(Tutoria tutoria) {
//		String matricula = tutoria.getMatricula();
//		
//		if (alunos.containsKey(matricula)) {
//			
//			Aluno aluno = alunos.get(matricula);
//			
//			if (aluno.getTutoria() == null) {
//				alunos.get(matricula).tornarTutor(tutoria);
//			} else {
//				throw new RuntimeException("O aluno ja eh tutor");
//			}
//			
//			return aluno;
//			
//		}
//		
//		throw new RuntimeException("Aluno nao encontrado");
//	}
//
//	public Aluno cadastraHorario(Horario horario) {
//		String matricula = horario.getMatricula();
//		
//		if (isTutor(matricula)) {
//			Aluno aluno = alunos.get(matricula);
//			aluno.getTutoria().adicionaHorario(horario);
//			return aluno;
//		}
//		
//		throw new RuntimeException("Tutor nao encontrado");	
//		
//
//	}
//
//	public boolean getDisponibilidadeHorario(String matricula, String dia, String hora) {
//		
//		if (isTutor(matricula)) {
//			Aluno aluno = alunos.get(matricula);
//			Horario tempHorario = new Horario(DiaDaSemana.valueOf(dia), hora);
//			return aluno.getTutoria().getListaHorarios().contains(tempHorario);
//		}
//		
//		throw new RuntimeException("Tutor nao encontrado");
//	}
//
//	public boolean getDisponibilidadeLocal(String matricula, String local) {
//		if (isTutor(matricula)) {
//			Aluno aluno = alunos.get(matricula);
//			System.out.println(aluno.getTutoria().getLocais().size());
//			Local localTemp = new Local(local);
//			System.out.println(localTemp);
//			System.out.println(aluno.getTutoria().getLocais().contains(localTemp));
//			return aluno.getTutoria().getLocais().contains(new Local(local));
//		}
//		
//		throw new RuntimeException("Tutor nao encontrado");
//	}
//	
//	
//	public Aluno cadastraLocal(Local local) {
//		if (isTutor(local.getMatricula())) {
//			Aluno aluno = alunos.get(local.getMatricula());
//			aluno.getTutoria().adicionaLocal(local);
//			return aluno;
//		}
//		
//		throw new RuntimeException("Tutor nao encontrado");
//	}
//	
//	
//	private boolean isTutor(String matricula) {
//		
//		if (alunos.containsKey(matricula)) {
//			
//			Aluno aluno = alunos.get(matricula);
//			
//			if (aluno.getTutoria() != null) 
//				return true;
//			
//		}
//		
//		return false;
//		
//	}
//
//	public Aluno getTutorAjudaOnline(PedidoAjuda pedido) {
//		
//		for (Aluno aluno: alunos.values()) {
//			
//			if (isTutor(aluno.getMatricula())) {
//				System.out.println("TUTOR");
//				System.out.println(aluno.getTutoria().getDisciplina());
//				System.out.println(pedido.getDisciplina());
//				if (aluno.getTutoria().getDisciplina().equals(pedido.getDisciplina())) {
//					return aluno;
//				}
//			}
//		}
//		
//		throw new RuntimeException("Nenhum tutor foi encontrado para essa disciplina");
//	}
//
//	public Aluno getTutorAjudaPresencial(PedidoAjuda pedido) {
//		
//		Horario horario = new Horario(DiaDaSemana.valueOf(pedido.getDia()), pedido.getHora());
//		Local local = new Local(pedido.getLocal());
//		
//		for (Aluno aluno: alunos.values()) {
//			
//			if (isTutor(aluno.getMatricula())) {
//				if (aluno.getTutoria().getDisciplina().equals(pedido.getDisciplina()) &&
//						aluno.getTutoria().getListaHorarios().contains(horario) &&
//						aluno.getTutoria().getLocais().contains(local)) {
//					return aluno;
//				}
//			}
//		}
//		
//		throw new RuntimeException("Nenhum tutor foi encontrado para essa disciplina, horario e local");
//	}
	
	
	
	
}

