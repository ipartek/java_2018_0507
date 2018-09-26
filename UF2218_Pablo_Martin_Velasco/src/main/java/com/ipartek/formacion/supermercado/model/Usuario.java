package com.ipartek.formacion.supermercado.model;

public class Usuario {
	
	private String nombre;
	private String pass;
	
	public Usuario() {
		super();
		this.nombre = "";
		this.pass = "";
	}

		
	public Usuario(String nombre, String pass) {
		this();
		this.nombre = nombre;
		this.pass = pass;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + "]";
	}
	
}
