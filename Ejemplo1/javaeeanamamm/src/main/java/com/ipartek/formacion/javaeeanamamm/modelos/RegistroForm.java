package com.ipartek.formacion.javaeeanamamm.modelos;

public class RegistroForm extends RuntimeException{
	
	private String nombre;
	private String email;
	private String contraseña;
	
	

	private String mensajeError;

	
	public RegistroForm() {
		this("","","");
		}
	
	
	
	public RegistroForm(String nombre, String email, String contraseña, String mensajeError) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.mensajeError = mensajeError;
	}



	public RegistroForm(String nombre, String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
