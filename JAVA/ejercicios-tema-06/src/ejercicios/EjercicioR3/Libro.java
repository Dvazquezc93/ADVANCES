package ejercicios.EjercicioR3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Libro {
private String titulo;
private String autor;
private String isbn;
private BigDecimal  precio;

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
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public BigDecimal  getPrecio() {
	return precio;
}
public void setPrecio(BigDecimal  precio) {
	this.precio = precio;
}
@Override
public int hashCode() {
	return Objects.hash(isbn);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Libro other = (Libro) obj;
	return Objects.equals(isbn, other.isbn);
}


}
