package ejercicios.EjercicioR4;

import java.time.LocalDate;

public  class Libro {
	protected String titulo;
	protected String autor;
	protected LocalDate fechaEdicion;
	protected Integer numeroPaginas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public Integer getPeso() {
		return 0;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", fechaEdicion=" + fechaEdicion + ", numeroPaginas="
				+ numeroPaginas + "]";
	}
	
}
