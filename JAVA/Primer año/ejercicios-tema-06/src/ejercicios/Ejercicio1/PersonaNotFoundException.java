package ejercicios.Ejercicio1;

public class PersonaNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1290602707760656675L;

	public PersonaNotFoundException() {
	}

	public PersonaNotFoundException(String message) {
		super(message);
	}

	public PersonaNotFoundException(Throwable cause) {
		super(cause);
	}

	public PersonaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
