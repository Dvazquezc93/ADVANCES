package modelo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Obrero {
	protected String dni;
	protected String nombre;
	protected BigDecimal sueldoBase;
	protected String especialidad;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(BigDecimal sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public BigDecimal getSueldoFinal() {
		return getSueldoBase();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obrero other = (Obrero) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#,###.00 €");
		return "dni= " + dni + "\n nombre=" + nombre + "\n sueldoBase=" + formato.format(sueldoBase)
				+ "\n especialidad=" + especialidad;
	}

}
