package ejercicios.Ejercicios06;

public class ParametroIncorrectoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7110702915094415524L;

	public ParametroIncorrectoException() {
	}

	public ParametroIncorrectoException(String message) {
		super(message);
	}

	public ParametroIncorrectoException(Throwable cause) {
		super(cause);
	}

	public ParametroIncorrectoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParametroIncorrectoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
