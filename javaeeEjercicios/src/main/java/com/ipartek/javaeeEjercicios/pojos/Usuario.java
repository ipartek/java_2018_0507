package com.ipartek.javaeeEjercicios.pojos;

public class Usuario {
	private Long id;
	private String email;
	private String password;
	private String mensajeError = "";
	
	private String errorEmail = "";
	private String errorPassword = "";
	
	private boolean erroneo = false;
	
	private static final String EMAIL_REGEX = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if (!email.matches(EMAIL_REGEX)) {
			setErrorEmail("Introduce un email valido");
			setErroneo(true);
			throw new UsuarioException("Introduce un email valido");
		}
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.trim().length() == 0) {
			setErrorPassword("Es obligatorio rellenar el password");
			setErroneo(true);
			throw new UsuarioException("Es obligatorio rellenar el password");
		}
		this.password = password;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}

	public boolean isErroneo() {
		return erroneo;
	}

	public void setErroneo(boolean erroneo) {
		this.erroneo = erroneo;
	}

	
}
