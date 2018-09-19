package com.ipartek.supermercado.pojo;

public class Usuario {
	String nombre,nombreReal,password,error="";
	boolean logeado=false;
	public boolean isLogeado() {
		return logeado;
	}
	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}
	
	public Usuario() {
		
	}
	public Usuario(String nombre,String nombreReal,String password) {
		this.nombre=nombre;
		this.password=password;
		this.nombreReal=nombreReal;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long id;
public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
}
