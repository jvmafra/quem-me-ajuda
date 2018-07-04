package qma.ajuda;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import qma.aluno.Aluno;

@Entity
public class Ajuda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long id;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private Aluno aluno;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private Aluno tutor;
	
	@Column
	private String disciplina;

	@Column
	private String dia;
	
	@Column
	private String hora;
	
	@Column
	private String local;
	
	public Ajuda() {
		
	}
	
	public Ajuda(Aluno aluno, Aluno tutor, String disciplina) {
		this.aluno = aluno;
		this.tutor = tutor;
		this.disciplina = disciplina;
		this.dia = "";
		this.hora = "";
		this.local = "";
		
	}
	
	public Ajuda(Aluno aluno, Aluno tutor, String disciplina, String dia, String hora, String local) {
		this.aluno = aluno;
		this.tutor = tutor;
		this.disciplina = disciplina;
		this.dia = dia;
		this.hora = hora;
		this.local = local;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getTutor() {
		return tutor;
	}

	public void setTutor(Aluno tutor) {
		this.tutor = tutor;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	

}