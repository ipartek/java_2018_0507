package com.ipartek.formacion.javaee.servlets;

public class LoginForm {

	private String nombre;
	private String contraseña;
	private String mensajeError;
	
	public LoginForm(String nombre, String contraseña, String mensajeError) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.mensajeError = mensajeError;
	}
	public LoginForm(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public LoginForm() {
		this("","","");
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	

	
}
