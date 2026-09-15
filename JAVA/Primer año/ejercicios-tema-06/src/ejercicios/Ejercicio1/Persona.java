package ejercicios.Ejercicio1;

import java.time.LocalDate;

public class Persona {
	private String nombre;
	private String dni;
	private String apellidos;
	private LocalDate fechaNacimiento;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void validar() throws DatosIncompletosException {
		if (nombre == null || apellidos == null ||  nombre.length() > 50
				|| apellidos.length() > 50 || dni.length() > 50 || fechaNacimiento.compareTo(LocalDate.now()) >= 0
						|| nombre.isBlank() || apellidos.isBlank() || dni.isBlank()) {
			throw new DatosIncompletosException("No ha introducido correctamente los datos de la persona.");
		}
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
}
