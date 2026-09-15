package ejercicios.EjerciciosR4;

public class EstadoIncorrectoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193238591410679502L;

	public EstadoIncorrectoException() {
	}

	public EstadoIncorrectoException(String message) {
		super(message);
	}

	public EstadoIncorrectoException(Throwable cause) {
		super(cause);
	}

	public EstadoIncorrectoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EstadoIncorrectoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
