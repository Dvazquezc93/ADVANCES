package ejercicios.Ejercicio34;

public class Ropa extends Articulo {
	private String talla;
	private String color;

	public Ropa(String talla, String color) {
		super();
		this.talla = talla;
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public String getColor() {
		return color;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
