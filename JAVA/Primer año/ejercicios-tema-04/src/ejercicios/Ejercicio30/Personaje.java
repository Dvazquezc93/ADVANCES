package ejercicios.Ejercicio30;

import java.util.Objects;

public abstract class Personaje {
	protected String nombre;
	protected String codigo;
	protected Integer vida;
	protected Integer daño;
	protected Integer velocidadAtaque;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getVida() {
		return vida;
	}

	public Integer getDaño() {
		return daño;
	}

	public Integer getVelocidadAtaque() {
		return velocidadAtaque;
	}

	public abstract String getType();

	@Override
	public String toString() {
		return "Tipo de personaje=  " + getType() + " nombre=" + nombre + ", codigo=" + codigo + ", Vida=" + vida
				+ ", daño=" + daño + ", velocidadAtaque=" + velocidadAtaque + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre);
	}

}
