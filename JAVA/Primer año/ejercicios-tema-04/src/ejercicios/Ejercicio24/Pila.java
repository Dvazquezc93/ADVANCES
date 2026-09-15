package ejercicios.Ejercicio24;

import java.util.ArrayList;
import java.util.List;

public class Pila {
	private List<String> lisPp;

	public Pila() {
		lisPp = new ArrayList<>();
	}

	public void añadirCadena(String recibo) {
		lisPp.add(0, recibo);
	}

	public String sacarCadena() {
		if (lisPp.isEmpty()) {
			return null;
		}
		return lisPp.remove(0);
	}

	public Integer getTamaño() {
		return lisPp.size();
	}

	@Override
	public String toString() {
		return "Pila [" + lisPp + "]";
	}

	

}
