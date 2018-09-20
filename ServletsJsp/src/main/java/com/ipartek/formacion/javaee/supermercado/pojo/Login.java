package com.ipartek.formacion.javaee.supermercado.pojo;

public class Login {
	private String nombre = "";
	private String clave = "";
	private String recordar = "";
	private String mensajeError;
	private String mensajeErrorUsuario;
	private String mensajeErrorClave;
	
	public Login(String nombre, String clave, String recordar, String mensajeError,
			String mensajeErrorUsuario, String mensajeErrorClave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.recordar = recordar;
		this.mensajeError = mensajeError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.mensajeErrorClave = mensajeErrorClave;
	}
	public Login(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}
	public Login(String recordar) {
		this.recordar = recordar;
	}
	public Login() {
		this("","","","","","");
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRecordar() {
		return recordar;
	}
	public void setRecordar(String recordar) {
		this.recordar = recordar;
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

