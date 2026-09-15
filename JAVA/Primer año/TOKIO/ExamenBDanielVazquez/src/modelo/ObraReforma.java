package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ObraReforma extends ObraNueva {
	protected LocalDate fechaUltimaReforma;

	public ObraReforma(String direccion) {
		super(direccion);
		fechaUltimaReforma = LocalDate.now();
	}

	public LocalDate getFechaUltimaReforma() {
		return fechaUltimaReforma;
	}

	public void setFechaUltimaReforma(LocalDate fechaUltimaReforma) {
		this.fechaUltimaReforma = fechaUltimaReforma;
	}

	@Override
	public BigDecimal getPenalizacion() {
		if (getFechaUltimaReforma().equals(LocalDate.now())) {
			return BigDecimal.ZERO;
		}
		return getPresupuesto().multiply(BigDecimal.valueOf(0.10));
	}

}
