package qma.aluno;
import javax.persistence.Column;
import static java.util.Objects.isNull;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Inheritance(strategy = javax.persistence.InheritanceType.TABLE_PER_CLASS)
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column
	@Id
	private String matricula;
	
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	private String senha;
	
	@Column
	private String nome;
	
	@Column
	private String codCurso;
	
	@Column
	private String telefone;
	
	@Column
	private String email;

	public Aluno() {
		
	}
	
	public Aluno(String matricula, String nome, String senha, String codCurso, String telefone,
			String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
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
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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