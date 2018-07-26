package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre = "";
	private String password = "";
	private String apellido = "";
	
	private String mensajeError = "";
	
	private String errorNombre = "";
	private String errorApellido = "";
	private String errorPassword = "";
	
	private boolean erroneo = false;

	// OBLIGATORIO PARA PODER USAR <jsp:useBean
	public LoginForm() {
	}

	@Override
	public String toString() {
		return "LoginForm [nombre=" + nombre + ", password=" + password + ", mensajeError=" + mensajeError + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre){
		if (nombre == null || nombre.trim().length() == 0) {
			setErrorNombre("Es obligatorio rellenar el nombre");
			setErroneo(true);
			throw new LoginFormException("Es obligatorio rellenar el nombre");
		}
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.trim().length() == 0) {
			setErrorPassword("Es obligatorio rellenar el password");
			setErroneo(true);
			throw new LoginFormException("Es obligatorio rellenar el password");
		}
		this.password = password;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}
	public String getErrorApellido() {
		return errorApellido;
	}
	public void setErrorApellido(String errorApellido) {
		this.errorApellido = errorApellido;
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
