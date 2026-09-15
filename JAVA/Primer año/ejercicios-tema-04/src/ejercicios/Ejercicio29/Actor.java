package ejercicios.Ejercicio29;

public class Actor extends Participante {

	@Override
	public Integer getSueldo() {
		return SUELDO_ACTOR;
		
	}

	@Override
	public String toString() {
		return nombre;
	}

}
