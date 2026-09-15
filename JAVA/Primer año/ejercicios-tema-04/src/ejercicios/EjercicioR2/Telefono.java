package ejercicios.EjercicioR2;

public abstract class Telefono {
	protected Integer numero;
	protected Boolean enLlamada;

	
	public Integer consultarNumero() {
		return numero;
	}

	public void marcar(Integer marcador) {
		System.out.println("LLAMANDO A " + marcador + "...");
		if (!(numero.equals(marcador))) {
			System.out.println("EN COMUNICACIÓN");
			enLlamada = true;
		} else {
			System.out.println("COMUNICANDO");
		}
	}
	public void colgar() {
		if (enLlamada) {
			System.out.println("COMUNICACIÓN TERMINADA");
			enLlamada = false;
		}
	}

}
