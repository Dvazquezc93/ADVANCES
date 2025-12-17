package ejercicios.Ejercicio03;

public class Libro {
	private String titulo;
	private String autor;
	private Integer paginasLeidas;
	private Integer totalPaginas;

	public Libro(String nuevoTitulo, String nuevoAutor, Integer nuevoTotalPaginas) {
		titulo = nuevoTitulo;
		autor = nuevoAutor;
		paginasLeidas = 0;
		totalPaginas = nuevoTotalPaginas;
	}

	public Integer leer(Integer paginasUsuario) {
		paginasLeidas += paginasUsuario;
		if (paginasLeidas > totalPaginas) {
			totalPaginas = paginasLeidas;
		}

		return paginasLeidas;

	}

	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public Integer retroceder(Integer paginasUsuario) {
		paginasLeidas -= paginasUsuario;
		if (paginasLeidas < 0) {
			totalPaginas = 0;
		}

		return paginasLeidas;

	}

	public void reinicar() {
		paginasLeidas = 0;
	}

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

	public Double progreso() {
		Double porcentaje = (paginasLeidas.doubleValue() /totalPaginas.doubleValue() ) * 100;
		return porcentaje;
	}
	
}
