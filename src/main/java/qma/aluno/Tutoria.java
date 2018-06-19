package qma.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tutoria  {
	
	@Column
	@Id
	private String matricula;
	
	@Column
	private String disciplina;
	
	@Column
	private String proficiencia;
	
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
	

}
