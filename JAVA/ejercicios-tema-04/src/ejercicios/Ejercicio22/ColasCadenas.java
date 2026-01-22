package ejercicios.Ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class ColasCadenas {
	private List<String> lisCc;

	public ColasCadenas() {
		lisCc = new ArrayList<>();
	}

	public void añadirCadena(String recibo) {
		if (lisCc.size() == 0) {
			lisCc.add(recibo);
		} else {
			lisCc.add(lisCc.size() - 1, recibo);
		}

	}

	public String sacarCadena() {
		String removeDelete = lisCc.get(0);
		lisCc.remove(0);
		return removeDelete;
	}

	public Integer getTamaño() {
		return lisCc.size();
	}

	@Override
	public List toString() {
		return lisCc;
	}
}
