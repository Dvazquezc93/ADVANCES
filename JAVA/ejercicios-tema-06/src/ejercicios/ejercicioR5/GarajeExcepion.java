package ejercicios.ejercicioR5;

public class GarajeExcepion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001332974195677430L;

	public GarajeExcepion() {
	}

	public GarajeExcepion(String message) {
		super(message);
	}

	public GarajeExcepion(Throwable cause) {
		super(cause);
	}

	public GarajeExcepion(String message, Throwable cause) {
		super(message, cause);
	}

	public GarajeExcepion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
