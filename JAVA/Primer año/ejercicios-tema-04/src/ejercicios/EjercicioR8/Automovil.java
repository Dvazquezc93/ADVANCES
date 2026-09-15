package ejercicios.EjercicioR8;

import java.math.BigDecimal;

public abstract class Automovil {
	protected String matricula;
	protected BigDecimal kilometroRecorrido;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public BigDecimal getKilometroRecorrido() {
		return kilometroRecorrido;
	}

	public void setKilometrorecorrido(BigDecimal kilometroRecorrido) {
		this.kilometroRecorrido = kilometroRecorrido;
	}
	public abstract BigDecimal getExtraPeajes();
	
	public abstract BigDecimal getTonelaje();

	
	public BigDecimal getCostePeaje() {
		BigDecimal costePeaje = kilometroRecorrido;
		costePeaje= costePeaje.multiply(new BigDecimal(0.5)).add(getExtraPeajes());
		return costePeaje;
	}
	
}
