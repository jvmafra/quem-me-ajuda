package qma.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import qma.tutor.Horario;

@Entity
public class Local {
	
	@Id
	@Column
	private String matricula;
	
	@Column
	private String local;
	
	public Local() {
		
	}
	
	public Local(String matricula, String local) {
		this.matricula = matricula;
		this.local = local;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getLocal() {
		return local;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Local) {
			Local other = (Local) obj;
			
			return this.local.equals(other.getLocal());
		}
		
		return false;
	}

}
