package modelo;

import java.math.BigDecimal;

public class ObreroOficial extends Obrero {
	protected Integer añosExperiencia;

	public Integer getAñosExperiencia() {
		return añosExperiencia;
	}

	public void setAñosExperiencia(Integer añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}

	@Override
	public String toString() {
		return super.toString() + "\n añosExperiencia=" + añosExperiencia;
	}

	@Override
	public BigDecimal getSueldoFinal() {
		if (getAñosExperiencia() > 5) {
			return super.getSueldoFinal().add(BigDecimal.valueOf(10000));
		}
		return super.getSueldoFinal().add(BigDecimal.valueOf(10000));
	}
}
