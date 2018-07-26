package com.ipartek.formacion.javaee.modelos;

public class LoginFormException extends Exception { 
	//si se pone RuntimeException no hace falta try... catch o throw


	/**
	 * 
	 */
	private static final long serialVersionUID = -4243816990632407047L;

	public LoginFormException() {
		// TODO Auto-generated constructor stub
	}

	public LoginFormException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LoginFormException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public LoginFormException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoginFormException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
