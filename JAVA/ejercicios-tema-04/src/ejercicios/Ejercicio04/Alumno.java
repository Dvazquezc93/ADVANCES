package ejercicios.Ejercicio04;

import ejercicios.Ejercicio07.Persona;
import ejercicios.Ejercicio08.Curso;

public class Alumno extends Persona {
	private String dni;
	private Double nota;
	private Curso curso;

	public Alumno(String dni) {

		this.dni = dni;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public void aprobar() {
		nota = 5.0;
	}

}
