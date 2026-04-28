package ejercicios.ejercicioR2;

public class PlantaServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6613997587943723168L;

	public PlantaServiceException() {
	}

	public PlantaServiceException(String message) {
		super(message);
	}

	public PlantaServiceException(Throwable cause) {
		super(cause);
	}

	public PlantaServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlantaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
