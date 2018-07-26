package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre = "";
	private String password = "";

	private String errorNombre = "";
	private String errorPassword = "";
	private String mensajeError = "";
	
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


	public void setNombre(String nombre) { //throws LoginFormException { // "              Hola Javier            ".trim() ---> "Hola Javier"

		if(nombre == null || nombre.trim().length() == 0) {  //ESTO TE BORRA CUALQUIER ESPACIO EXTRA QUE METAS AL PRINCIPIO O AL FINAL

			setErrorNombre("No se admiten nombres vacíos");
			setErroneo(true);
			throw new LoginFormException("No se admiten nombres vacíos");
		}
		this.nombre = nombre;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		if(password == null || password.trim().length() == 0) {

			setErrorPassword("No se admiten nombres vacíos");
			setErroneo(true);
			throw new LoginFormException("No se admiten passwords vacíos");

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
