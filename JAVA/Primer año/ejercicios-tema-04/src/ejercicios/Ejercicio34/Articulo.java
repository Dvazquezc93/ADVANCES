package ejercicios.Ejercicio34;

public abstract  class  Articulo {
	protected String descripcion;
	protected Double precio;

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
