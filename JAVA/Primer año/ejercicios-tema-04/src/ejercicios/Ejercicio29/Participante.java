package ejercicios.Ejercicio29;

public abstract class Participante {
	protected String nombre;
	protected Integer añoNacimiento;
	protected String nacionalidad;
	protected static final Integer SUELDO_ACTOR = 100000;
	protected static final Integer SUELDO_DIRECTOR = 50000;
	protected static final Integer SUELDO_GUIONISTA = 200000;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAñoNacimiento() {
		return añoNacimiento;
	}

	public void setAñoNacimiento(Integer añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public abstract Integer getSueldo();
}
