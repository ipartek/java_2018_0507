package com.ipartek.formacion.javaee.uf2218.logica;

public class LogicaNegocioException extends RuntimeException {

	private static final long serialVersionUID = -2836295397991815246L;

	public LogicaNegocioException() {
	}

	public LogicaNegocioException(String message) {
		super(message);
	}

	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}

	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
