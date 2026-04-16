package ejercicios.Ejercicio1;

public class DatosIncompletosException extends Exception {

	public DatosIncompletosException() {
	}

	public DatosIncompletosException(String message) {
		super(message);
	}

	public DatosIncompletosException(Throwable cause) {
		super(cause);
	}

	public DatosIncompletosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatosIncompletosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
