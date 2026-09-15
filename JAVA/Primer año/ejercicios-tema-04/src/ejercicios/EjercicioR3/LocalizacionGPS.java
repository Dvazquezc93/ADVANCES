package ejercicios.EjercicioR3;

import java.math.BigDecimal;

public class LocalizacionGPS {
	private BigDecimal posicionGpsx;
	private BigDecimal posicionGpsy;

	public LocalizacionGPS(BigDecimal posicionGpsx, BigDecimal posicionGpsy) {
		super();
		this.posicionGpsx = posicionGpsx;
		this.posicionGpsy = posicionGpsy;
	}

	public BigDecimal getPosicionGpsx() {
		return posicionGpsx;
	}

	public void setPosicionGpsx(BigDecimal posicionGpsx) {
		this.posicionGpsx = posicionGpsx;
	}

	public BigDecimal getPosicionGpsy() {
		return posicionGpsy;
	}

	public void setPosicionGpsy(BigDecimal posicionGpsy) {
		this.posicionGpsy = posicionGpsy;
	}

	@Override
	public String toString() {
		return "LocalizacionGPS [posicionGpsx=" + posicionGpsx + ", posicionGpsy=" + posicionGpsy + "]";
	}

}
