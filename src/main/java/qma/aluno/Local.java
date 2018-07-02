package qma.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Local {
	
	@Id
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	private String matricula;
	
	@Column
	private String local;
	
	public Local() {
		
	}
	
	public Local(String local) {
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
