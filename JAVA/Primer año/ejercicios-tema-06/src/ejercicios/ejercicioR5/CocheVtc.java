package ejercicios.ejercicioR5;

import java.math.BigDecimal;

public class CocheVtc extends Coche{

	public CocheVtc(String matricula, Cliente cliente) {
		super(matricula, cliente);
		// TODO Auto-generated constructor stub
	}
 @Override
 public BigDecimal getPago() {
	 if (super.getPago().equals(BigDecimal.ZERO)) {
		return BigDecimal.ZERO;
	}
	 return super.getPago().subtract(new BigDecimal (10.75));
 }
}
