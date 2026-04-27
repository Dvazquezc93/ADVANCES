package ejercicios.EjercicioFinalR1;

public class ProductoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061770703372181637L;

	public ProductoInvalidoException() {
	}

	public ProductoInvalidoException(String message) {
		super(message);
	}

	public ProductoInvalidoException(Throwable cause) {
		super(cause);
	}

	public ProductoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductoInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
