package qma.aluno;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import qma.tutor.Horario;

@Entity
public class Tutoria  {
	
	@Column
	@Id
	private String matricula;
	
	@Column
	private String disciplina;
	
	@Column
	private String proficiencia;
	
	@JoinColumn
	@OneToMany
	private Set<Horario> listaHorarios = new HashSet<>();
	
	@Column
	@OneToMany
	private Set<Local> locais = new HashSet<>();

	public Tutoria (String matricula, String disciplina, String proficiencia) {
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
	}
	
	public Tutoria() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(String proficiencia) {
		this.proficiencia = proficiencia;
	}
	
	public Set<Horario> getListaHorarios() {
		return listaHorarios;
	}
	
	public void adicionaHorario (Horario horario) {
		this.listaHorarios.add(horario);
	}
	
	public Set<Local> getLocais() {
		return locais;
	}
	
	public void adicionaLocal(Local local) {
		this.locais.add(local);
	}
	

}
