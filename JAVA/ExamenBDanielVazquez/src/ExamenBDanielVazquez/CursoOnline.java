package ExamenBDanielVazquez;

import java.math.BigDecimal;

public class CursoOnline extends Curso {
	private Boolean tutorAsociado;

	public CursoOnline(String nombre, BigDecimal precio) {
		super(nombre, precio);
		tutorAsociado = false;
	}

	public Boolean getTutorAsociado() {
		return tutorAsociado;
	}

	public void setTutorAsociado(Boolean tutorAsociado) {
		this.tutorAsociado = tutorAsociado;
	}
	
	public BigDecimal getPrecio() {
		if (tutorAsociado) {
			precio= precio.multiply(new BigDecimal(2));
		}
		return precio;
	}

	@Override
	public Boolean permiteMatricula() {
		
		return true;
	}
}
