package ejercicios.Ejercicios07;

public class ListaVaciaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3991371318856547410L;

	public ListaVaciaException() {
	}

	public ListaVaciaException(String message) {
		super(message);
	}

	public ListaVaciaException(Throwable cause) {
		super(cause);
	}

	public ListaVaciaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListaVaciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
