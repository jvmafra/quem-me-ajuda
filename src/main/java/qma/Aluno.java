package qma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	public String matricula;
	
	@Column
	public String nome;
	
	@Column
	public String codCurso;
	
	@Column
	public String telefone;
	
	@Column
	public String email;
	
}
