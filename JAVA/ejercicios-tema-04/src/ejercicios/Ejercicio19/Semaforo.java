package ejercicios.Ejercicio19;

public class Semaforo {
	public static final String COLOR = "Rojo";
	public static final String COLOR1 = "Ámbar";
	public static final String COLOR2 = "Verde";
	private String color;
	private Boolean parpadeando;

	public Semaforo() {
		super();
		this.color = COLOR;
		this.parpadeando = false;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color.equals(COLOR) || color.equals(COLOR1) || color.equals(COLOR2)) {
			this.color = color;
		} else {
			System.out.println("COLOR ERRONEO");
		}

	}

	public Boolean getParpadeando() {
		return parpadeando;
	}

	public void setParpadeando(Boolean parpadeando) {
		if (color.equals(COLOR1) && parpadeando) {

			this.parpadeando = parpadeando;
		} else {
			parpadeando = false;
			this.parpadeando = parpadeando;
		}

	}

	@Override
	public String toString() {
		String imPar = "";
		if (parpadeando == true) {
			imPar = " parpadeando";
		}
		return "Semaforo en " + color + imPar;
	}

	public void cambiarEstado() {
		if (color.equals(COLOR2)) {
			color = COLOR1;
			parpadeando = true;
		} else if (color.equals(COLOR1) && parpadeando) {
			color = COLOR1;
			parpadeando = false;
		} else if (color.equals(COLOR1) ) {
			color = COLOR;
		} else if (color.equals(COLOR)) {
			color = COLOR2;
		}
	}

}
