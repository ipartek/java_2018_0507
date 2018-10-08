package controladores;

public class ControladorException extends RuntimeException {

	private static final long serialVersionUID = -3994743668519093880L;

	public ControladorException() {
	}

	public ControladorException(String message) {
		super(message);
	}

	public ControladorException(Throwable cause) {
		super(cause);
	}

	public ControladorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControladorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
