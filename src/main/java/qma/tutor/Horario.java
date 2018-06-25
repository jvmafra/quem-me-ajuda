package qma.tutor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Horario {
	
	@Id
	@Column
	private String matricula;

	@Column
	private DiaDaSemana dia;
	
	@Column
	private String hora;
	
	public Horario (DiaDaSemana dia, String hora) {
		this.dia = dia;
		this.hora = hora;
	}
	
	public Horario() {
		
	}

	public DiaDaSemana getDia() {
		return dia;
	}

	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String horario) {
		this.hora = horario;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Horario: " + this.dia.toString() + " - " + this.hora;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Horario) {
			Horario other = (Horario) obj;
			
			return this.dia.equals(other.getDia()) && this.hora.equals(other.getHora());
		}
		
		return false;
	}
	
	
	
	
	
	

}
