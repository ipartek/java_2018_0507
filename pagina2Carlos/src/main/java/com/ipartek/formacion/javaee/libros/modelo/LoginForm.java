package com.ipartek.formacion.javaee.libros.modelo;

public class LoginForm {

	private String nombre = "";
	private String contrasenia = "";
	private String mensajeError;
	private String mensajeErrorUsuario;
	private String mensajeErrorClave;
	
	public LoginForm(String nombre, String contrasenia, String mensajeError,
			String mensajeErrorUsuario, String mensajeErrorClave) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.mensajeError = mensajeError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.mensajeErrorClave = mensajeErrorClave;
	}
	public LoginForm(String nombre, String contrasenia) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
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
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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
