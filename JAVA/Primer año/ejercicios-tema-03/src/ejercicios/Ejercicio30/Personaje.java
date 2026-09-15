package ejercicios.Ejercicio30;

public abstract class Personaje {
	protected String nombre;
	protected String codigo;
	protected Integer vida;
	protected Integer daño;
	protected Integer velocidadAtaque;

	public Personaje() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		vida = vida;
	}

	public Integer getDaño() {
		return daño;
	}

	public void setDaño(Integer daño) {
		this.daño = daño;
	}

	public Integer getVelocidadAtaque() {
		return velocidadAtaque;
	}

	public void setVelocidadAtaque(Integer velocidadAtaque) {
		this.velocidadAtaque = velocidadAtaque;
	}

	public abstract String getType();

	@Override
	public String toString() {
		return "Tipo de personaje" + getType() + "nombre=" + nombre + ", codigo=" + codigo + ", Vida=" + Vida
				+ ", daño=" + daño + ", velocidadAtaque=" + velocidadAtaque;
	}

}
