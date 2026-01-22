package ejercicios.Ejercicio08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicios.Ejercicio04.Alumno;

public class Curso {
	protected Long identificador;
	protected String descripcion;
	private List<Alumno> ArraAlumnos;

	public Curso() {
		 arraAlumnos = new ArrayList<>();
		
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [identificador=" + identificador + ", descripcion=" + descripcion + "]";
	}

	public Alumno getAlumnos() {
		return alumnos;
	}

	public void addAlumno(Alumno a) {
		for (Integer i = 0; i < alumnos.length; i++) {
			if (alumnos[i]==null) {
				alumnos[i]=a;
			}
			
		}
	}

}
