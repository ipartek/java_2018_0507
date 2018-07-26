package com.ipartek.formacion.prestamolibros.pojo;

import java.util.List;

//TODO: Quitar el @SuppressWarnings("unused")
@SuppressWarnings("unused")
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
<<<<<<< HEAD
	
	
=======

>>>>>>> branch 'Piero' of https://github.com/ipartek/java_2018_0507.git
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

	public void setLibrosPrestados(List<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((librosPrestados == null) ? 0 : librosPrestados.hashCode());
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
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (id != other.id)
			return false;
		if (librosPrestados == null) {
			if (other.librosPrestados != null)
				return false;
		} else if (!librosPrestados.equals(other.librosPrestados))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

	
	
}
