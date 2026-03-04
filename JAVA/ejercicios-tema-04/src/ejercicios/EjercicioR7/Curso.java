package ejercicios.EjercicioR7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class Curso {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private BigDecimal precio;
	private Integer plazasTotales;
	private Integer plazasOcupadas;
	public Curso(String nombre, BigDecimal precio, Integer plazasTotales) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.plazasTotales = plazasTotales;
		plazasOcupadas=0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getPlazasTotales() {
		return plazasTotales;
	}
	public void setPlazasTotales(Integer plazasTotales) {
		this.plazasTotales = plazasTotales;
	}
	public Integer getPlazasOcupadas() {
		return plazasOcupadas;
	}
	public void setPlazasOcupadas(Integer plazasOcupadas) {
		this.plazasOcupadas = plazasOcupadas;
	}
	public Integer getDuracionCurso() {
		if (fechaInicio.isAfter(fechaFin)) {
			Period periodo =fechaInicio.until(fechaFin);
			return periodo.getMonths()+(periodo.getYears()/12);
		}
		return 0;
	}
	public Boolean isPlazasLibres() {
		return plazasOcupadas<plazasTotales; 
	}
	public BigDecimal getPrecioMes() {
		if (getDuracionCurso()==0) {
			return BigDecimal.ZERO;
		}
		return precio.divide(new BigDecimal(getDuracionCurso()),2, RoundingMode.HALF_EVEN); 
	}
}

