package ejercicios.Ejercicio04;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public Boolean validarDni() {
		if (dni == null || dni.isEmpty()) {
			return false;
		}
		Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
		Matcher match = patron.matcher(dni);
		return (match.matches());

	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + getNombre() + "edad=" + getEdad() + "dni=" + dni + ", nota=" + nota + ", curso="
				+ curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public Boolean Validar() {
		if (!validarDni()) {
			return false;
		}
		if (curso == null) {
			return false;
		}
		if (nombre == null || nombre.length() < 10) {
			return false;
		}
		if (edad == null || edad < 12 || edad >65) {
			return false;
		}
		return true;
	}
}
