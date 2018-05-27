package qma;

import javax.persistence.Column;
import static java.util.Objects.isNull;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Column
	@Id
	private String matricula;
	
	@Column
	private String nome;
	
	@Column
	private String codCurso;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	public Aluno(String matricula, String nome, String codCurso, String telefone,
			String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.codCurso = codCurso;
		this.telefone = telefone;
		this.email = email;
		
	}
	
	public Aluno(String matricula, String nome, String codCurso,
			String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.codCurso = codCurso;
		this.email = email;
		
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		if (!isNull(this.matricula)) {
			return this.matricula + " - " + this.nome + " - " + this.codCurso +
					" - " + this.telefone + " - " + this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.codCurso +
					 " - " + this.email;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aluno) {
			return ((Aluno) obj).getMatricula() == this.getMatricula();
		}
		
		return false;
	}
	
	
	
}
