package qma.aluno;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
	
	@Column
	@OneToMany(cascade = CascadeType.ALL)
	private List<Horario> listaHorarios = new ArrayList<>();
	
	@Column
	@OneToMany(cascade = CascadeType.ALL)
	private List<Local> locais = new ArrayList<>();

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
	
	public List<Horario> getListaHorarios() {
		return listaHorarios;
	}
	
	public void setListHorarios(List<Horario> horarios) {
		this.listaHorarios = horarios;
	}
	
	public void adicionaHorario (Horario horario) {
		if (!this.listaHorarios.contains(horario)) {
			this.listaHorarios.add(horario);
		}
	}
	
	public List<Local> getLocais() {
		return locais;
	}
	
	public void adicionaLocal(Local local) {
		if (!this.locais.contains(local)) {
			this.locais.add(local);
		}
		
	}
	

}
