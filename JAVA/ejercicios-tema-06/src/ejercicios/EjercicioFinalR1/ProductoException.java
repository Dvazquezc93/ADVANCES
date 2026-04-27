package ejercicios.EjercicioFinalR1;

public class ProductoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7038329715513021707L;

	public ProductoException() {
	}

	public ProductoException(String message) {
		super(message);
	}

	public ProductoException(Throwable cause) {
		super(cause);
	}

	public ProductoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
