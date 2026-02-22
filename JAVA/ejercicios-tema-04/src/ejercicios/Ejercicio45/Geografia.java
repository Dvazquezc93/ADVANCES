package ejercicios.Ejercicio45;

import java.util.HashMap;
import java.util.Map;

public class Geografia {
	private Map<String, String> paises;

	public Geografia() {
		paises = new HashMap<>();
	}

	public Boolean agregarPais(String pais, String capital) {
		pais = pais.toUpperCase();
		capital = capital.substring(0, 1).toUpperCase() + capital.substring(1);
		if (paises.containsKey(pais)) {
			paises.put(pais, capital);
			return true;
		}
		paises.put(pais, capital);
		return false;

	}

	public String obtenerCapital(String pais) {
		pais = pais.toUpperCase();
		if (paises.containsKey(pais)) {
			return paises.get(pais);
		}
		return "";

	}
	public String imprimirPaises(String pais) {
		String imprimirPaises ="";
		for (String mapa : paises.keySet()) {
			imprimirPaises+="PAIS: \""+mapa+"\"*4- CAPITAL"
		} 
		return "";

	}
	

}
