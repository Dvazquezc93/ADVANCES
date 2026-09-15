package ejercicios.Ejercicio38;

import java.math.BigDecimal;

public abstract class Articulo {
	protected String descripcion;
	protected Double precio;

	public Articulo() {
		precio=0.0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public BigDecimal getPrecio() {
		return BigDecimal.valueOf(precio);
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
