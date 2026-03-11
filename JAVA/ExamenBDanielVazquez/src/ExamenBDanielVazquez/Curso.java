package ExamenBDanielVazquez;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Curso {
	protected String nombre;
	protected Integer experienciaMinima;
	protected BigDecimal precio;
	protected List<Alumno> listaAlumno;

	public Curso(String nombre, BigDecimal precio) {
		this.nombre = nombre;
		experienciaMinima = 0;
		this.precio = precio;
		listaAlumno = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getExperienciaMinima() {
		return experienciaMinima;
	}

	public void setExperienciaMinima(Integer experienciaMinima) {
		this.experienciaMinima = experienciaMinima;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

	public abstract Boolean permiteMatricula();

	public Boolean matricularAlumno(Alumno alumno) {
		if (listaAlumno.contains(alumno)) {
			return true;
		}
		Period periodo = alumno.getFechaContratacion().until(LocalDate.now());
		Integer experienciaAlumno = periodo.getYears();
		if (experienciaAlumno.compareTo(experienciaMinima)>=0 && permiteMatricula()) {
			listaAlumno.add(alumno);
			return true;
		}
		return false;
	}

	public Boolean isMatriculado(String dni) {
		for (Alumno alumno : listaAlumno) {
			if (alumno.getDni().equalsIgnoreCase(dni)) {
				return true;
			}
		}
		return false;
	}
}
