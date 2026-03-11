package ExamenBDanielVazquez;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Academia {
	protected String nombre;
	protected List<Curso> listaCurso;

	public Academia() {

		listaCurso = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public BigDecimal getCuotaAlumno(String dni) {
		BigDecimal cuotaAlumno = BigDecimal.ZERO;
		for (Curso curso : listaCurso) {
			for (Alumno alumno : curso.getListaAlumno()) {
				if (alumno.getDni().equalsIgnoreCase(dni)) {
					cuotaAlumno = cuotaAlumno.add(curso.getPrecio());
				}
			}
		}
		return cuotaAlumno;
	}

	public Curso getCursoMasBarato(Integer experiencia) {
		Curso cursoBarato = null;
		for (Curso curso : listaCurso) {
			for (Alumno alumno : curso.getListaAlumno()) {
				Period periodo = alumno.getFechaContratacion().until(LocalDate.now());
				Integer experienciaAlumno = periodo.getYears();
				if (experienciaAlumno >= experiencia && cursoBarato == null) {
					cursoBarato = curso;
				}
				if (experienciaAlumno >= experiencia && curso.getPrecio().compareTo(cursoBarato.getPrecio()) < 0) {
					cursoBarato = curso;
				}
			}
		}
		return cursoBarato;
	}

	public Integer matricularAlumno(Alumno alumno) {
		Integer contador = 0;
		for (Curso curso : listaCurso) {
			Boolean matriculado = curso.matricularAlumno(alumno);
			if (matriculado) {
				contador++;
			}
		}
		return contador;
	}

	public Integer borrarCursosVacios() {
		Integer contador = 0;
		for (Iterator<Curso> iterator = listaCurso.iterator(); iterator.hasNext();) {
			Curso curso = iterator.next();
			if (curso.getListaAlumno().isEmpty()) {
				iterator.remove();
				contador++;
			}

		}
		return contador;
	}
}
