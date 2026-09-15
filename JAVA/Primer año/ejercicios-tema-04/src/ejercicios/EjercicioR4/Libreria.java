package ejercicios.EjercicioR4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Libreria {
	private List<Libro> listaLibros;
	private String direccion;
	private Integer numeroTelefono;

	public Libreria() {
		listaLibros = new ArrayList<>();

	}

	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Libro obteberLibroMasAntiguo() {
		if (listaLibros.isEmpty()) {
			return null;
		}
		Libro libroAntiguo = new Libro();
		libroAntiguo.setFechaEdicion(LocalDate.now());
		for (Libro libro : listaLibros) {
			if (libroAntiguo.getFechaEdicion().isAfter(libro.getFechaEdicion())) {
				libroAntiguo = libro;
			}
		}
		return libroAntiguo;
	}

	public Integer ObtenerPesoTotalDeLibros() {
		Integer peso = 0;
		for (Libro libro : listaLibros) {
			peso += libro.getPeso();
		}
		return peso;
	}

	public BigDecimal ObtenerNumPaginasMedio() {
		BigDecimal media = BigDecimal.ZERO;
		if (!listaLibros.isEmpty()) {
			for (Libro libro : listaLibros) {
				media = media.add(new BigDecimal(libro.getNumeroPaginas()));
			}
			return media.divide(new BigDecimal(listaLibros.size()), 2, RoundingMode.HALF_EVEN);
		}
		return media;
	}
}
