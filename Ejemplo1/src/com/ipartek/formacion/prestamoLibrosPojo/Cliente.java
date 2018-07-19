package com.ipartek.formacion.prestamoLibrosPojo;

import java.util.List;


public class Cliente {
	private long id;
	private String dni;		//TODO: private DNI dni;
	private String nombre;
	private String apellido;
	private List<Libro> librosPrestado;
	
	public boolean isLibre() { 
		//TODO: implementar isLibre
		throw new RuntimeException("No implementado");
	}
	
	public Cliente(long id, String dni, String nombre, String apellido, List<Libro> librosPrestado) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.librosPrestado = librosPrestado;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", librosPrestado=" + librosPrestado + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Libro> getLibrosPrestado() {
		return librosPrestado;
	}

	public void setLibrosPrestado(List<Libro> librosPrestado) {
		this.librosPrestado = librosPrestado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((librosPrestado == null) ? 0 : librosPrestado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (id != other.id)
			return false;
		if (librosPrestado == null) {
			if (other.librosPrestado != null)
				return false;
		} else if (!librosPrestado.equals(other.librosPrestado))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
