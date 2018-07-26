package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre;
	private String password;
	
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

	public LoginForm() { //CUANDO USAMOS EL USEBEAN EN EL JSP ES OBLIGATORIO CREAR ESTE CONTRUCTOR VACIO SI O SI
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
		if (nombre.trim().length() ==0) {  //ESTO TE BORRA CUALQUIER ESPACIO EXTRA QUE METAS AL PRINCIPIO O AL FINAL
			throw new LoginFormException("No se admiten espacios");
		}
		else
			this.nombre= nombre;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if ("".equals(password) || password.length()>6) {
			
		}
		this.password = password;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
