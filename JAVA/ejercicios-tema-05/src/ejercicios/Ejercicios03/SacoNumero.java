package ejercicios.Ejercicios03;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SacoNumero {
	private List<Integer> listaNumero;

	public SacoNumero() {

		listaNumero = new ArrayList<>();
	}

	public void addNumero(Integer numero) {
		listaNumero.add(numero);
	}

	public Integer getNumero(Integer numero) {
		try {
			return listaNumero.get(numero);
		} catch (Exception e) {
			return null;
		}

	}

	public BigDecimal division() {
		try {
			BigDecimal dividir = BigDecimal.valueOf(listaNumero.get(0));
			for (int i = 1; i < listaNumero.size(); i++) {
				try {
					dividir = dividir.divide(BigDecimal.valueOf(listaNumero.get(i)), 2, RoundingMode.HALF_UP);

				} catch (ArithmeticException e) {
					dividir = BigDecimal.ZERO;
				}
			}
			return dividir;
		} catch (IndexOutOfBoundsException e) {
			return BigDecimal.ZERO;
		}
		
		
	}

	@Override
	public String toString() {
		return "SacoNumero [listaNumero=" + listaNumero + "]";
	}

}
