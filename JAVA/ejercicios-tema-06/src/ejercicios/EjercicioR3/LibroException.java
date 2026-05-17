package ejercicios.EjercicioR3;

public class LibroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5893213402392042432L;

	public LibroException() {
	}

	public LibroException(String message) {
		super(message);
	}

	public LibroException(Throwable cause) {
		super(cause);
	}

	public LibroException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
