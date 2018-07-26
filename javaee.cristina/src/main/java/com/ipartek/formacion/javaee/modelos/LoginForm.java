package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre;
	private String password;
	
	private String errorNombre;
	private String mensajeError;

	public LoginForm(String nombre, String password, String mensajeError) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.mensajeError = mensajeError;
	}

	public LoginForm(String nombre, String password) {
		this(nombre, password, "");
	}

	public LoginForm() { //Obligatorio poner el constructor vacio usando useBean
		this("", "", "");
	}
	@Override
	public String toString() {
		return "LoginForm [nombre=" + nombre + ", password=" + password + ", mensajeError=" + mensajeError + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws LoginFormException {
		if(nombre.trim().length() == 0) {
			throw new LoginFormException("No se admite nombres vacíos");
		}
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
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
}
