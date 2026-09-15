package ejercicios.Ejercicio40;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Retirada extends Movimiento{

	@Override
	public String tipoMovimiento() {
		return " R ";
	}

	@Override
	public String extraMovimiento() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void setImporte(BigDecimal importe) {
		this.importe =importe.negate();
		fecha= LocalDate.now();
	}

}
