package ejercicios.Ejercicio45;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
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
		return paises.getOrDefault(pais, "");

	}

	public void imprimirPaises() {

		for (String mapa : paises.keySet()) {
			System.out.println("PAIS: \"" + mapa + "\"- CAPITAL: \"" + paises.get(mapa) + "\"\n");
		}

	}

	public void eliminarPais(String pais) {
		pais = pais.toUpperCase();
		paises.remove(pais);
	}

	public BigDecimal calcularLongitudMediaPaises() {
		BigDecimal media = BigDecimal.ZERO;
		if (!paises.isEmpty()) {
			for (String mediaPaises : paises.keySet()) {
				media =media.add(new BigDecimal(mediaPaises.length()));
			}
			media=media.divide(new BigDecimal(paises.size()));
		}
		return media.setScale(2, RoundingMode.HALF_EVEN);
	}

	public void eliminarPaisConCapitalLetra(String letraCapital) {
		letraCapital = letraCapital.toUpperCase();
		for (Iterator<String> iterator = paises.keySet().iterator(); iterator.hasNext();) {
			String paisMapa = iterator.next();
			if (paises.get(paisMapa).startsWith(letraCapital)) {
				iterator.remove();
				break;
			}
		}
	}

	public Integer numeroPaisesConCapitalLetra(String letraCapital) {
		Integer contador = 0;
		letraCapital = letraCapital.toUpperCase();
		for (String pais : paises.keySet()) {
			
			if (paises.get(pais).startsWith(letraCapital)) {
				contador++;
			}
		}
		return contador;
	}

	public void imprimirNumeroPaisesLetra(String letraCapital) {
		letraCapital = letraCapital.toUpperCase();
		Boolean vacio = true;
		for (String mapa : paises.keySet()) {
			if (paises.get(mapa).startsWith(letraCapital)) {
				if (vacio) {
					System.out.println("La letra " + letraCapital + " contiene:\n");
				}
				 System.out.println("\tPAIS: \"" + mapa + "\" - CAPITAL: \"" + paises.get(mapa) + "\"\n");;
				vacio = false;
			}
		}
		if (vacio) {
			System.out.println("Ninguna capital del mapa comienza por " + letraCapital + ".");;
		}
		
	}

	public String mismaLetra() {
		String imprimirPaises = "Estos paises tienen la misma letra:\n";

		Boolean vacio = true;
		for (String mapa : paises.keySet()) {
			String capitalLetra = paises.get(mapa).substring(0, 1).toUpperCase();
			String paisLetra = mapa.substring(0, 1).toUpperCase();
			if (paisLetra.equals(capitalLetra)) {
				imprimirPaises += "\tPAIS: \"" + mapa + "\"- CAPITAL:\"" + paises.get(mapa) + "\"\n";
				vacio = false;
			}
		}
		if (vacio) {
			return "No hay ningún país y capital que comiencen por la misma letra";
		}
		return imprimirPaises;
	}
}
