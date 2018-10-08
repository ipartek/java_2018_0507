package com.ipartek.formacion.ong.modelos;

public class Usuario {

	private long id = -1L;
	private String nombre = "";
	private String password = "";

	private String errorNombre = "";
	private String errorPassword = "";

	private boolean correcto = true;
	
	public Usuario(long id, String nombre, String password) {
		super();
		this.id = id;
		setNombre(nombre);
		setPassword(password);
	}
	public Usuario(String nombre, String password) {
		this(-1L, nombre, password);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			setErrorNombre("No se admite un nombre vacio");

		}

		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null) {
			setErrorPassword("No se admite una contraseña nula");
			setCorrecto(false);
			return;
		}
		
		if(password.trim().length() < 8) {
			setErrorPassword("No se admite una contraseña menor de 8 caracteres");
			setCorrecto(false);
			return;
		}
		
		this.password = password;
	}

	private void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
	
	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		correcto = false;
		this.errorPassword = errorPassword;
	}

	public String getErrorNombre() {
		return errorNombre;
	}
	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}
	public boolean isCorrecto() {
		return correcto;
	}
	
	
}
