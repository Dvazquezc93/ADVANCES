package ExamenBDanielVazquez;

import java.math.BigDecimal;

public class AcademiaUniversitaria extends Academia {
	private Boolean salaEstudio;

	public AcademiaUniversitaria() {
		salaEstudio = false;
	}

	public Boolean getSalaEstudio() {
		return salaEstudio;
	}

	public void setSalaEstudio(Boolean salaEstudio) {
		this.salaEstudio = salaEstudio;
	}

	public BigDecimal getCuotaAlumno(String dni) {

		if (salaEstudio) {

			return super.getCuotaAlumno(dni).add(new BigDecimal(20));
		}
		return super.getCuotaAlumno(dni);
	}
}
