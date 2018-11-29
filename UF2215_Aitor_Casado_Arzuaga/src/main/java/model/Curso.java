package model;

import java.sql.Date;

public class Curso {
	
	private String nombre;
	private String identificador;
	private int nHoras;
	private Profesor profesor;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String nombre, String identificador, int nHoras, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.nHoras = nHoras;
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", identificador=" + identificador + ", nHoras=" + nHoras + ", profesor="
				+ profesor + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getnHoras() {
		return nHoras;
	}

	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + nHoras;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		Curso other = (Curso) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nHoras != other.nHoras)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}
	
		

}
