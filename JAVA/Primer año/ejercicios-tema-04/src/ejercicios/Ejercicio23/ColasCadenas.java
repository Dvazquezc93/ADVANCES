package ejercicios.Ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class ColasCadenas {
	private List<String> lisCc;

	public ColasCadenas() {
		lisCc = new ArrayList<>();
	}

	public void añadirCadena(String recibo) {
		lisCc.add(recibo);
	}

	public String sacarCadena() {
		if (lisCc.isEmpty()) {
			return null;
		}
		return lisCc.remove(0);
	}

	public Integer getTamaño() {
		return lisCc.size();
	}

	@Override
	public String toString() {
		return "ColasCadenas [" + lisCc + "]";
	}

}
