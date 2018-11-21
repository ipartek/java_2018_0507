package com.ipartek.formacion.biblioteca;

public class BibliotecaException extends RuntimeException {

	private static final long serialVersionUID = -7647812190523614067L;

	public BibliotecaException() {
	}

	public BibliotecaException(String message) {
		super(message);
	}

	public BibliotecaException(Throwable cause) {
		super(cause);
	}

	public BibliotecaException(String message, Throwable cause) {
		super(message, cause);
	}

	public BibliotecaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
