package ejercicios.Ejercicio09;

import ejercicios.Ejercicio07.Persona;
import ejercicios.Ejercicio08.Curso;

public class Profesor extends Persona{
	private String dni;
	private Integer numeroAlumnos;
	private Curso curso;

	public Profesor(String dni) {

		this.dni = dni;
	}

	public Integer getnumeroAlumnos() {
		return numeroAlumnos;
	}
	public void setNumeroAlumnos(Integer numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Profesor [nombre="+getNombre()+", edad="+ getEdad()+ ", dni=" + dni + ", numeroAlumnos=" + numeroAlumnos + ", curso=" + curso + "]";
	}
}
