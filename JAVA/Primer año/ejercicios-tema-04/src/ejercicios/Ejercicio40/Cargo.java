package ejercicios.Ejercicio40;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cargo extends Movimiento{
	protected String cif;

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Override
	public String tipoMovimiento() {
		// TODO Auto-generated method stub
		return " C ";
	}

	@Override
	public String extraMovimiento() {
		// TODO Auto-generated method stub
		return " - "+cif;
	}

	@Override
	public void setImporte(BigDecimal importe) {
		this.importe =importe.negate();
		fecha= LocalDate.now();
		
	}
}
