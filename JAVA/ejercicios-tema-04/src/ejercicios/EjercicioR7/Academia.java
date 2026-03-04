package ejercicios.EjercicioR7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Academia {
	private String ciudad;
	private Integer telefono;
	private List<Curso> listaCurso;
	private Map<String, Alumno> mapaAlumno;

	public Academia() {
		mapaAlumno = new HashMap<>();
		listaCurso = new ArrayList<>();
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public List<Curso> getCursoDisponible() {
		List<Curso> curDispo = new ArrayList<>();
		for (Curso curso : listaCurso) {
			if (curso.isPlazasLibres() && curso.getFechaFin().isBefore(LocalDate.now())) {
				curDispo.add(curso);
			}
		}
		return curDispo;
	}

	public BigDecimal getPrecioMedio() {
		BigDecimal precioMedio = BigDecimal.ZERO;
		if (!(listaCurso.isEmpty())) {
			for (Curso curso : listaCurso) {
				precioMedio = precioMedio.add(curso.getPrecio());
			}
			precioMedio = precioMedio.divide(new BigDecimal(listaCurso.size()), 2, RoundingMode.HALF_EVEN);
		}
		return precioMedio;
	}

	public void borrarCursoPasados() {
		for (Iterator<Curso> iterator = listaCurso.iterator(); iterator.hasNext();) {
			Curso curso = iterator.next();
			if (curso.getFechaFin().compareTo(LocalDate.now()) > 0) {
				iterator.remove();
			}
		}
	}

	public Curso getCursoMasBarato() {
		Curso cursoBarato = null;
		for (Curso curso : listaCurso) {
			if (cursoBarato.getPrecio().compareTo(curso.getPrecio()) < 0
					&& curso.getFechaInicio().isAfter(LocalDate.now()) || cursoBarato == null) {
				cursoBarato = curso;
			}
		}
		return cursoBarato;

	}

	public Integer getTotalPlazasLibres() {
		if (!(listaCurso.isEmpty())) {
			Integer plazasLibres = 0;
			for (Curso curso : listaCurso) {
				if (curso.isPlazasLibres()) {
					plazasLibres += (curso.getPlazasTotales() - curso.getPlazasOcupadas());
				}
			}
			return plazasLibres;
		}
		return 0;
	}

	public List<Alumno> buscarAlumnos(String letra) {
		List<Alumno> listaAlumno = new ArrayList<>();
		for (String alumno : mapaAlumno.keySet()) {
			if (alumno.contains(letra) && mapaAlumno.get(alumno).getNota().compareTo(new BigDecimal(5)) >= 0) {
				listaAlumno.add(mapaAlumno.get(alumno));
			}
		}
		return listaAlumno;
	}

	public Alumno getPeorNota(BigDecimal minima) {
		Alumno peorNota = null;
		for (Alumno alumno : mapaAlumno.values()) {
			if (alumno.getNota().compareTo(minima) > 0 && (alumno.getNota().compareTo(peorNota.getNota()) < 0
					|| peorNota == null)) {
				peorNota = alumno;
			}
		}
		return peorNota;
	}

	public Alumno getJovenCiudad() {
		Alumno jovenSevilla = null;
		for (Alumno alumno : mapaAlumno.values()) {
			if (alumno.getCiudad().equals("Sevilla") &&( jovenSevilla == null
					|| alumno.getFechaNacimiento().compareTo(jovenSevilla.getFechaNacimiento()) > 0)) {
				jovenSevilla = alumno;
			}
		}
		return jovenSevilla;
	}

}
