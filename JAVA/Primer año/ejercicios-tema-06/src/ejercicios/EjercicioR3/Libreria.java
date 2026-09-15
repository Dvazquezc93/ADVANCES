package ejercicios.EjercicioR3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Libreria {
	private String nombre;
	private Map<String, Libro> mapaLibro;

	public Libreria() {
		mapaLibro = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Libro> getMapaLibro() {
		return mapaLibro;
	}

	public void setMapaLibro(Map<String, Libro> mapaLibro) {
		this.mapaLibro = mapaLibro;
	}

	public BigDecimal getTasacionCompleta() {
		BigDecimal precioTotal = BigDecimal.ZERO;
		for (Libro libro : mapaLibro.values()) {
			precioTotal = precioTotal.add(libro.getPrecio());
		}
		return precioTotal;
	}
	
	public BigDecimal getPrecioMedio() {
		if (!mapaLibro.isEmpty()) {
			return getTasacionCompleta().divide(BigDecimal.valueOf(mapaLibro.size()), 2, RoundingMode.HALF_DOWN);
		}
		return BigDecimal.ZERO;
	}
	public List< Libro > getLibrosBaratos() {
		List<Libro> libroBarato = new ArrayList();
		for (Libro libro : mapaLibro.values()) {
			if (libro.getPrecio().compareTo(BigDecimal.valueOf(10))<10) {
				libroBarato.add(libro);
			}
		}
		return libroBarato;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libreria other = (Libreria) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
