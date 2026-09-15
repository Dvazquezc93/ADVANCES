package ejercicios.Ejercicios07;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ejercicios.Ejercicios06.ParametroIncorrectoException;
import ejercicios.Ejercicios06.Persona;

public class Sociedad {
	private Set<Persona> conjuntoPersonas;

	public Sociedad() {

		conjuntoPersonas = new HashSet<>();
	}

	public void addPersona(String genero, BigDecimal altura) throws ParametroIncorrectoException {
		Persona p1 = new Persona();
		try {
			p1.setGenero(genero);
			p1.setAltura(altura);
			conjuntoPersonas.add(p1);
		} catch (ParametroIncorrectoException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public BigDecimal alturaMedia() {
		try {
			return calcularMedia(null);
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal alturaMediaHombre() {
		try {
			return calcularMedia("H");
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal alturaMediaMujer() {
		try {
			return calcularMedia("M");
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
			return BigDecimal.ZERO;
		}
	}

	private BigDecimal calcularMedia(String genero) throws ListaVaciaException {
		BigDecimal media = BigDecimal.ZERO;
		Integer contador = 0;
		
			for (Persona persona : conjuntoPersonas) {
				if (persona.getGenero().equalsIgnoreCase(genero) || genero == null) {
					media = media.add(persona.getAltura());
					contador++;
				}
			}
			return media = media.divide(BigDecimal.valueOf(contador), 2, RoundingMode.HALF_UP);
	if (contador==0) {
		throw new ListaVaciaException("ERROR LA LISTA ESTA VACIA.");
	}

	}
	public void borrarGenero(String genero) throws ParametroIncorrectoException {
		if (genero.toUpperCase().equals("M") || genero.toUpperCase().equals("H")) {
			for (Iterator<Persona> iterator = conjuntoPersonas.iterator(); iterator.hasNext();) {
				Persona persona =  iterator.next();
				if (persona.getGenero().equalsIgnoreCase(genero)) {
					iterator.remove();
				}
			}
		}
		else {
			throw new ParametroIncorrectoException();
		}
		
	}
}
