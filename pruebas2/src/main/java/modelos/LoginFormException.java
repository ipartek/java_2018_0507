package modelos;

public class LoginFormException extends RuntimeException {
	
	private static final long serialVersionUID = -4243816990632407047L;

	public LoginFormException() {
		
	}

	public LoginFormException(String message) {
		super(message);
		
	}

	public LoginFormException(Throwable cause) {
		super(cause);
		
	}

	public LoginFormException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LoginFormException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
