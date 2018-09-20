package com.ipartek.superonline.pojo;

public class Usuario {

	private String nombre, contrasena;
	private long ID;


	public Usuario() {
		
	}

	public Usuario(String nombre, String contrasena, long ID) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.ID = ID;
	}

	
	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
	
	
	

}
