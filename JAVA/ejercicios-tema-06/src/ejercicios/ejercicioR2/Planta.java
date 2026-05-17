package ejercicios.ejercicioR2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Planta {
	private Long id;
	private String nombre;
	private String tipo;
	private BigDecimal altura;
	private LocalDate fechaPlantacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public LocalDate getFechaPlantacion() {
		return fechaPlantacion;
	}

	public void setFechaPlantacion(LocalDate fechaPlantacion) {
		this.fechaPlantacion = fechaPlantacion;
	}
	public Boolean validarAltura() {
		return getAltura().compareTo(BigDecimal.valueOf(2))>0;
	}
	@Override
	public String toString() {
		return "Plantas [nombre=" + nombre + ", tipo=" + tipo + ", altura=" + altura + "]";
	}

}
