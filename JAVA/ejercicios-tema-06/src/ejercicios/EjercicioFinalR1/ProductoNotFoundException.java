package ejercicios.EjercicioFinalR1;

public class ProductoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7778322140110186471L;

	public ProductoNotFoundException() {
	}

	public ProductoNotFoundException(String message) {
		super(message);
	}

	public ProductoNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProductoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
