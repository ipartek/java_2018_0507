package com.ipartek.txarkur.controladores;

public class ControladoresException extends RuntimeException {

	private static final long serialVersionUID = 7100309229131464378L;

	public ControladoresException() {
		
	}

	public ControladoresException(String message) {
		super(message);
		
	}

	public ControladoresException(Throwable cause) {
		super(cause);
		
	}

	public ControladoresException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ControladoresException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
