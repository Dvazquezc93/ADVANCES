package ejercicios.EjercicioR2;

import java.math.BigDecimal;



public class Movil extends Telefono {
	private BigDecimal posicionGpsx;
	private BigDecimal posicionGpsy;

	public Movil(Integer numero,BigDecimal posicionx,BigDecimal posiciony) {
		this.numero=numero;
		this.posicionGpsx = posicionx;
		this.posicionGpsy = posiciony;
		enLlamada=false;
	}




}
