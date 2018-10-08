package accesoDatos;

public class AccesoDatos extends RuntimeException {

	private static final long serialVersionUID = -2525901880879590984L;

	public AccesoDatos() {
	}

	public AccesoDatos(String message) {
		super(message);
	}

	public AccesoDatos(Throwable cause) {
		super(cause);
	}

	public AccesoDatos(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatos(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
