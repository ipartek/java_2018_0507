package com.formacion.prestamoLibro.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private long id;
	private String dni,nombre,apellidos;//mejorar a clase y excepcion¿?¡?¿?¿?¿
	private List<Libro> librosPrestados=new ArrayList<>();
	
	public Cliente(long id, String dni, String nombre, String apellidos) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void addLibro(Libro librosPrestado) {
		System.out.println(librosPrestado.getTitulo()+"adsdasddsd");
		if(librosPrestados!=null)
		this.librosPrestados.add(librosPrestado);
	}

	@Override
	public String toString() {
		
		for(int i=0;i<librosPrestados.size();i++)
		{
			return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
					+ ", librosPrestados=" + librosPrestados.get(i) + "]";
		}
		return"Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				 + "]";
	}
}
