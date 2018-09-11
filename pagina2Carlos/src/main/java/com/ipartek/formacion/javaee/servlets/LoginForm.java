package com.ipartek.formacion.javaee.servlets;

public class LoginForm {

	private String nombre = "";
	private String contraseña = "";
	private String mensajeError;
	private String mensajeErrorUsuario;
	private String mensajeErrorClave;
	
	public LoginForm(String nombre, String contraseña, String mensajeError,
			String mensajeErrorUsuario, String mensajeErrorClave) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.mensajeError = mensajeError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.mensajeErrorClave = mensajeErrorClave;
	}
	public LoginForm(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public LoginForm() {
		this("","","","","");
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
	public String getMensajeErrorUsuario() {
		return mensajeErrorUsuario;
	}
	public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
		this.mensajeErrorUsuario = mensajeErrorUsuario;
	}
	public String getMensajeErrorClave() {
		return mensajeErrorClave;
	}
	public void setMensajeErrorClave(String mensajeErrorClave) {
		this.mensajeErrorClave = mensajeErrorClave;
	}
	
	

	
}
