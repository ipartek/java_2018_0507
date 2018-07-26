package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre;
	private String password;
	private String apellido;
	
	private String mensajeError;
	
	private String errorNombre;
	private String errorApellido;
	private String errorPassword;

	public LoginForm() {
		this("","","","","");
	}
	
	public LoginForm(String nombre, String password) {
		this(nombre,password,"","","");
	}
	public LoginForm(String nombre, String apellido, String password) {
		this(nombre,apellido,password,"","","","");
	}

	public LoginForm(String nombre, String password, String mensajeError, String errorNombre, String errorPassword) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.mensajeError = mensajeError;
		this.errorNombre = errorNombre;
		this.errorPassword = errorPassword;
	}
	public LoginForm(String nombre, String apellido, String password, String mensajeError, String errorNombre, String errorApellido, String errorPassword) {
		this.nombre = nombre;
		this.password = password;
		this.mensajeError = mensajeError;
		this.errorNombre = errorNombre;
		this.errorApellido = errorApellido;
		this.errorPassword = errorPassword;
	}

	@Override
	public String toString() {
		return "LoginForm [nombre=" + nombre + ", password=" + password + ", mensajeError=" + mensajeError + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
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
	
}	
