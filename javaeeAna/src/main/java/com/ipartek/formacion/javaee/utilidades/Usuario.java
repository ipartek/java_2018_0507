package com.ipartek.formacion.javaee.utilidades;

public class Usuario {
	public String dni;
	public String nombre;
	public String password;
	public String apellido;
	public String poblacion;
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public Usuario(String dni,String nombre,String password,String apellido,String poblacion ) {
		this.dni=dni;
		this.nombre=nombre;
		this.password=password;
		this.apellido=apellido;
		this.poblacion=poblacion;
	}
	
	
}
