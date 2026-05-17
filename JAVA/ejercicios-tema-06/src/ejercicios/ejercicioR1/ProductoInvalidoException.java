package ejercicios.ejercicioR1;

public class ProductoInvalidoException extends Exception {

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
