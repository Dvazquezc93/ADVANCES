package ejercicios.Ejercicio1;

public class PersonaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5218979840057766335L;

	public PersonaException() {
	}

	public PersonaException(String message) {
		super(message);
	}

	public PersonaException(Throwable cause) {
		super(cause);
	}

	public PersonaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
