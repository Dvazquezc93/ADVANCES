package ejercicios.Ejercicio39;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Hucha {
	protected BigDecimal dinero;

	public Hucha() {
		super();
		dinero = BigDecimal.ZERO;
	}

	public BigDecimal meterDinero(BigDecimal dinero) {
		this.dinero = this.dinero.add(dinero);
		return this.dinero.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal sacarDinero(BigDecimal dinero) {
		if (this.dinero.compareTo(dinero) < 0) {
			BigDecimal resto = this.dinero;
			this.dinero = BigDecimal.ZERO;
			return resto.setScale(2, RoundingMode.HALF_UP);

		}
		this.dinero = this.dinero.subtract(dinero);
		return this.dinero.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal contarDinero() {
		return this.dinero.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal romperHucha() {
		BigDecimal roto = dinero;
		dinero = BigDecimal.ZERO;
		return roto.setScale(2, RoundingMode.HALF_UP);
	}

	public String formatoHucha() {
		DecimalFormat formato = new DecimalFormat("#,##0.00 €");
		return formato.format(dinero);
	}

	@Override
	public String toString() {
		return "Hucha [dinero=" + formatoHucha() + "]";
	}

}
