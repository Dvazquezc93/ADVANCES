package modelo;

public class ObraEstadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1320786150216734188L;

	public ObraEstadoException() {
	}

	public ObraEstadoException(String message) {
		super(message);
	}

	public ObraEstadoException(Throwable cause) {
		super(cause);
	}

	public ObraEstadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObraEstadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
