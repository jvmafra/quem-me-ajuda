package qma.aluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import qma.exceptions.AlunoExistenteException;
import qma.exceptions.AlunoJaTutorException;
import qma.exceptions.AlunoNaoEncontradoException;
import qma.exceptions.LoginInvalidoException;
import qma.exceptions.TutorNaoEncontradoException;
import qma.security.JWTTokenProvider;
import qma.tutor.DiaDaSemana;
import qma.tutor.Horario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;


@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Aluno getByMatricula(String matricula) {
		Optional<Aluno> optUser = alunoRepository.findById(matricula);
		
		if (!optUser.isPresent()) {
			throw new AlunoNaoEncontradoException();
		}
		
		return optUser.get();
	}

	@Override
	@Transactional
	public Aluno save(Aluno aluno) {
		
		try {
			getByMatricula(aluno.getMatricula());
			throw new AlunoExistenteException();
			
		} catch (Exception e) {
			AlunoValidator.validaAluno(aluno);
			aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
			List<Role> roles = new ArrayList<Role>();
		    roles.add(Role.ROLE_ALUNO);
		    aluno.setRoles(roles);
			alunoRepository.save(aluno);
			return aluno;
		}
	}

	@Override
	public Iterable<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public String getInfoAluno(String matricula, String atributo) {
		Aluno aluno = getByMatricula(matricula);
		
		if (atributo == "Nome") {
			return aluno.getNome();
			
		} else if (atributo == "CodCurso") {
			return aluno.getCodCurso();
			
		} else if (atributo == "Telefone") {
			return aluno.getTelefone();
			
		} else if (atributo == "Email") {
			return aluno.getEmail();
			
		} else if (atributo == "Matricula") {
			return matricula;
			
		} else {
			throw new RuntimeException("Atributo nao encontrado");
		}
	}
	
	@Override
	public Aluno getTutorByMatricula(String matricula) {
		Aluno aluno = getByMatricula(matricula);
		if (aluno.getTutoria() != null) {
			return aluno;
		}
		
		throw new TutorNaoEncontradoException();
	}

	@Override
	public Iterable<Aluno> getAllTutores() {
		
		List<Aluno> tutores = new ArrayList<>();
		Iterable<Aluno> alunos = getAllAlunos();
		
		for (Aluno aluno: alunos) {
			if (aluno.getTutoria() != null) {
				tutores.add(aluno);
			}
		}
		
		return tutores;
		
	}

	@Override
	@Transactional
	public Aluno tornaTutor(Tutoria tutoria) {
		Aluno aluno = getByMatricula(tutoria.getMatricula());
		
		if (aluno.getTutoria() != null) {
			throw new AlunoJaTutorException();
		}
		
		aluno.tornarTutor(tutoria);
		return aluno;
	}

	@Override
	@Transactional
	public Aluno cadastraHorario(Horario horario) {
		String matricula = horario.getMatricula();
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);
			aluno.getTutoria().adicionaHorario(horario);
			return aluno;
		}
		
		throw new TutorNaoEncontradoException();
	}

	@Override
	public boolean getDisponibilidadeHorario(String matricula, String dia, String hora) {
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);
			Horario tempHorario = new Horario(DiaDaSemana.valueOf(dia), hora);
			return aluno.getTutoria().getListaHorarios().contains(tempHorario);
		}
		
		throw new TutorNaoEncontradoException();
	}

	@Override
	public boolean getDisponibilidadeLocal(String matricula, String local) {
		
		if (isTutor(matricula)) {
			Aluno aluno = getByMatricula(matricula);	
			return aluno.getTutoria().getLocais().contains(new Local(local));
		}
		
		throw new TutorNaoEncontradoException();
	}

	@Override
	@Transactional
	public Aluno cadastraLocal(Local local) {
		if (isTutor(local.getMatricula())) {
			Aluno aluno = getByMatricula(local.getMatricula());
			aluno.getTutoria().adicionaLocal(local);
			return aluno;
		}
		
		throw new TutorNaoEncontradoException();
	}
	
	
	public boolean isTutor(String matricula) {
	
		Aluno aluno = getByMatricula(matricula);
		System.out.println(aluno.getTutoria());
		if (aluno.getTutoria() != null) {
			return true;
		}
			
		return false;
	
	}
	
    public Map<String, String> login(Aluno aluno) {
    	
    	Aluno alunoFromDB;
    	
    	try {
    		alunoFromDB = getByMatricula(aluno.getMatricula());
		} catch (Exception e) {
			throw new LoginInvalidoException();
		}
    	
        
        if (!passwordEncoder.matches(aluno.getSenha(), alunoFromDB.getSenha())) {
        	throw new LoginInvalidoException();
        }

        String token = authUserAndGetToken(aluno.getMatricula(), aluno.getSenha(), aluno.getRoles());
        
        Map<String, String> credentials = new HashMap<>();
        credentials.put("token", token);
        credentials.put("matricula", aluno.getMatricula());
        return credentials;
    }
    
    private String authUserAndGetToken (String matricula, String password, List<Role> roles) {
        try{
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(matricula, password));
          return jwtTokenProvider.createToken(matricula, roles);
        } catch (AuthenticationException e) {
          throw new RuntimeException("Invalid token");
        }
    }
    
    public Aluno getUsuarioLogado() {
        String matricula = SecurityContextHolder.getContext().getAuthentication().getName();

        return getByMatricula(matricula);
    }

}
