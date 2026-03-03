package ejercicios.EjercicioR7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Academia {
	private String ciudad;
	private Integer telefono;
	private List<Curso> listaCurso;
	public Academia() {
	
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
		List<Curso> curDispo =new ArrayList<>();
		for (Curso curso : listaCurso) {
			if (curso.getPlazasOcupadas()<curso.getPlazasTotales()) {
				curDispo.add(curso);
			}
		}
		return curDispo;
	}
	public BigDecimal getPrecioMedio() {
		BigDecimal precioMedio =BigDecimal.ZERO;
		 if (!(listaCurso.isEmpty())) {
			 for (Curso curso : listaCurso) {
				precioMedio = precioMedio.add(curso.getPrecio()); 
			}
			 precioMedio=precioMedio.divide(new BigDecimal(listaCurso.size()),2,RoundingMode.HALF_EVEN);
		}
		return precioMedio;
	}
	public void borrarCursoPasados() {
		for (Iterator<Curso> iterator = listaCurso.iterator(); iterator.hasNext();) {
			Curso curso = iterator.next();
			if (curso.getFechaFin().compareTo(LocalDate.now())<0) {
				iterator.remove();
			}
		}
	}
	public BigDecimal getCursoMasBarato() {
		if (!(listaCurso.isEmpty())) {
			BigDecimal cursoBarato = listaCurso.get(0).getPrecio();
			for (Curso curso : listaCurso) {
				if (cursoBarato.compareTo(curso.getPrecio())>0) {
					cursoBarato=curso.getPrecio();
				}
			}
			return cursoBarato;
		}
		return BigDecimal.ZERO;
		
	}
	public Integer getTotalPlazasLibres() {
		if (!(listaCurso.isEmpty())) {
			Integer plazasLibres = 0;
			for (Curso curso : listaCurso) {
				if (curso.isPlazasLibres()) {
					plazasLibres+=(curso.getPlazasTotales()-curso.getPlazasOcupadas());
				}
			}
			return plazasLibres;
		}
		return 0;
	}
	
}
