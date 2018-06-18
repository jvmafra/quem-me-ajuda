package qma.tutor;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Entity;

import qma.aluno.Aluno;

@Entity
public class Tutor extends Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String disciplina;
	
	@Column
	private String proficiencia;
	
	@Column
	private double avaliacao;
	
	@Column
	private double dinheiroRecebido;
	
	
	public Tutor() {
		
	}
	
	public Tutor(String matricula, String nome, String senha, String codCurso, String telefone,
			String email, String disciplina, String proficiencia) {
		
		super(matricula, nome, senha, codCurso, telefone, email);
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.dinheiroRecebido = 0;
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

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public double getDinheiroRecebido() {
		return dinheiroRecebido;
	}

	public void setDinheiroRecebido(double dinheiroRecebido) {
		this.dinheiroRecebido = dinheiroRecebido;
	}
	
	@Override
	public String toString() {
		return "TUTOR: " + super.getNome() + " - " + this.disciplina;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Tutor) {
			Tutor other = (Tutor) obj;
			return super.equals(obj) && other.getDisciplina().equals(this.disciplina);
		}
		
		return false;
	}
	
}