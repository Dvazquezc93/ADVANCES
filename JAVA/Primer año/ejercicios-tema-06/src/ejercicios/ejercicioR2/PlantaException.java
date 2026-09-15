package ejercicios.ejercicioR2;

public class PlantaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2503869357294257903L;

	public PlantaException() {
	}

	public PlantaException(String message) {
		super(message);
	}

	public PlantaException(Throwable cause) {
		super(cause);
	}

	public PlantaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlantaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
