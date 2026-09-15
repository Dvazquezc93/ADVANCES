package ejercicios.Ejercicio40;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ingreso extends Movimiento{
	protected String descripcion ;

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String tipoMovimiento() {
		// TODO Auto-generated method stub
		return " I ";
	}

	@Override
	public String extraMovimiento() {
		// TODO Auto-generated method stub
		return " - "+descripcion;
	}

	@Override
	public void setImporte(BigDecimal importe) {
		this.importe =importe;
		fecha= LocalDate.now();
		
	}
}
