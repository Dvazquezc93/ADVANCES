package ejercicios.Ejercicio40;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Movimiento {
	protected LocalDate fecha;
	protected BigDecimal importe;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public abstract void setImporte(BigDecimal importe); 
	
	
	public String importeFormato() {
		DecimalFormat formato = new DecimalFormat("#,##0.00 €");
		return formato.format(importe);
	}

	public abstract String tipoMovimiento();

	public abstract String extraMovimiento();

	@Override
	public String toString() {
		return "Movimiento [" + tipoMovimiento() + " - " + fecha + " - " + importeFormato() + extraMovimiento() + "]";
	}

}
