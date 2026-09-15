package ejercicios.Ejercicio41;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Evaluacion {
	private Map<String, BigDecimal> alumnoNotas;

	public Evaluacion() {

		alumnoNotas = new HashMap<>();
	}

	public Boolean addNota(String dni, BigDecimal nota) {
		if (alumnoNotas.containsKey(dni)) {
			return false;
		}
		alumnoNotas.put(dni, nota);
		return true;
	}

	public Boolean corregirNota(String dni, BigDecimal nota) {
		if (alumnoNotas.containsKey(dni)) {
			alumnoNotas.put(dni, nota);
			return true;
		}
		return false;
	}

	public BigDecimal obtenerNotaAlumno(String dni) {
		if (alumnoNotas.containsKey(dni)) {
			return alumnoNotas.get(dni);
		}
		return BigDecimal.ZERO;
	}

	public BigDecimal obtenerNotaMedia() {
		BigDecimal media = BigDecimal.ZERO;
		if (alumnoNotas.isEmpty()) {
			return media;
		}
		for (BigDecimal nota : alumnoNotas.values()) {
			media = media.add(nota);
		}
		media = media.divide(new BigDecimal(alumnoNotas.size()), 2, RoundingMode.HALF_EVEN);
		return media;
	}

	public Integer obtenerCantidadAprobados() {
		Integer aprobados = 0;
		for (BigDecimal nota : alumnoNotas.values()) {
			if (nota.equals(new BigDecimal(5)) || nota.compareTo(new BigDecimal(5)) > 0) {
				aprobados++;
			}
		}

		return aprobados;
	}
	public List<String> obtenerSuspensos() {
		List<String> suspensos =new ArrayList<>();
		for (String dni : alumnoNotas.keySet()) {
			if (alumnoNotas.get(dni).compareTo(new BigDecimal(5)) < 0) {
			suspensos.add(dni);
			}
		}

		return suspensos;
	}
	public List<String> obtenerAprobados() {
		List<String> suspensos =new ArrayList<>();
		for (String dni : alumnoNotas.keySet()) {
			if (alumnoNotas.get(dni).equals(new BigDecimal(5))||alumnoNotas.get(dni).compareTo(new BigDecimal(5)) > 0) {
			suspensos.add(dni);
			}
		}

		return suspensos;
	}
	public void borrarAprobados() {
		for (Iterator<String> iterator = alumnoNotas.keySet().iterator(); iterator.hasNext();) {
			String dni= iterator.next();
			 if (alumnoNotas.get(dni).equals(new BigDecimal(5))|| alumnoNotas.get(dni).compareTo(new BigDecimal(5))>0) {
				iterator.remove();
			}
			
		}
		
	}

	@Override
	public String toString() {
		String aprobados= "Aprobados: \n";
		String suspensos= "Suspensos: \n";
		DecimalFormat formato = new DecimalFormat("#,###.00");
		for (String dni : alumnoNotas.keySet()) {
			if (alumnoNotas.get(dni).equals(new BigDecimal(5))||alumnoNotas.get(dni).compareTo(new BigDecimal(5)) > 0) {
				aprobados+="     "+dni+" ("+formato.format(alumnoNotas.get(dni))+")\n";
			}
			
		}
		for (String dni : alumnoNotas.keySet()) {
			if (alumnoNotas.get(dni).compareTo(new BigDecimal(5)) < 0) {
				suspensos+="     "+dni+" ("+formato.format(alumnoNotas.get(dni))+")\n";
			}
			
		}
		
		return aprobados + suspensos;
	}
	
}
