package ejercicios.ejercicioR2;

public class PlantaAlturaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7832915564490552245L;

	public PlantaAlturaException() {
	}

	public PlantaAlturaException(String message) {
		super(message);
	}

	public PlantaAlturaException(Throwable cause) {
		super(cause);
	}

	public PlantaAlturaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlantaAlturaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
