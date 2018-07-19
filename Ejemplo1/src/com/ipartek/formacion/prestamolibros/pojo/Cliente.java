package com.ipartek.formacion.prestamolibros.pojo;

import java.util.List;

public class Cliente {
	private long id;
	private String dni; //TODO: private Dni dni;
	private String nombre;
	private String apellidos;
	private List<Libro> librosPrestados;
	
	public Cliente(long id, String dni, String nombre, String apellidos,List<Libro> librosPrestados) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.librosPrestados = librosPrestados;
	}
	
	public Cliente() {
		this(-1,"","","", List<Libro>);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDni() {
		return dni;
	}

}
