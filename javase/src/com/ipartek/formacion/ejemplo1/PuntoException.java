package com.ipartek.formacion.ejemplo1;

public class PuntoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PuntoException() {
		
	}

	public PuntoException(String message) {
		super(message);
		
	}

	public PuntoException(Throwable cause) {
		super(cause);
		
	}

	public PuntoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PuntoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
