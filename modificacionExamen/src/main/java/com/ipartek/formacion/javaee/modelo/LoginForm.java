package com.ipartek.formacion.javaee.modelo;

public class LoginForm {
	private String nombre = "";
	private String clave = "";
	private String mensajeError;
	private String mensajeErrorUsuario;
	private String mensajeErrorClave;
	
	public LoginForm(String nombre, String clave, String mensajeError,
			String mensajeErrorUsuario, String mensajeErrorClave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.mensajeError = mensajeError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.mensajeErrorClave = mensajeErrorClave;
	}
	public LoginForm(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
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
		return clave;
	}
	public void setContraseña(String clave) {
		this.clave = clave;
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
