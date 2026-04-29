package ejercicios.EjerciciosR4;

public class NoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4517866028830766792L;

	public NoExisteException() {
	}

	public NoExisteException(String message) {
		super(message);
	}

	public NoExisteException(Throwable cause) {
		super(cause);
	}

	public NoExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
