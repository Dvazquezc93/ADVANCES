package ejercicios.EjercicioPrueba;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Animal {
	protected Integer numeroRegistro;
	protected LocalDate fechaNacimiento;
	protected BigDecimal peso;
	protected BigDecimal precioKilo;
	protected BigDecimal pesoMinimo;

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public BigDecimal getPrecioKilo() {
		return precioKilo;
	}

	public BigDecimal getPesoMinimo() {
		return pesoMinimo;
	}

	public Integer getEdad() {
		LocalDate diaActual = LocalDate.now();
		if (fechaNacimiento.compareTo(diaActual) < 0 || fechaNacimiento.equals(diaActual)) {
			Period periodo = fechaNacimiento.until(diaActual);
			return periodo.getMonths() + (periodo.getYears() * 12);
		}
		return null;
	}

	public Boolean sePuedeVender() {
		return pesoMinimo.equals(peso)||pesoMinimo.compareTo(peso)<0			;
	}

	public BigDecimal precioTotalVenta() {
		if (sePuedeVender()) {
			return precioKilo.multiply(peso);
		}
		return BigDecimal.ZERO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroRegistro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(numeroRegistro, other.numeroRegistro);
	}

}
