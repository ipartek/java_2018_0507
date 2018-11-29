package com.ipartek.formacion.UF2215.model;


public class Imparticion {
	String alumno_nombre;
	String alumno_apellidos;
	String curso_nombre;
	String curso_identificador;
	String curso_nHoras;
	String curso_profesornombre;
	
	public Imparticion(String alumno_nombre, String alumno_apellidos, String curso_nombre, String curso_identificador,
			String curso_nHoras, String curso_profesornombre) {
		super();
		this.alumno_nombre = alumno_nombre;
		this.alumno_apellidos = alumno_apellidos;
		this.curso_nombre = curso_nombre;
		this.curso_identificador = curso_identificador;
		this.curso_nHoras = curso_nHoras;
		this.curso_profesornombre = curso_profesornombre;
	}
	@Override
	public String toString() {
		return "Imparticion [alumno_nombre=" + alumno_nombre + ", alumno_apellidos=" + alumno_apellidos
				+ ", curso_nombre=" + curso_nombre + ", curso_identificador=" + curso_identificador + ", curso_nHoras="
				+ curso_nHoras + ", curso_profesornombre=" + curso_profesornombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno_apellidos == null) ? 0 : alumno_apellidos.hashCode());
		result = prime * result + ((alumno_nombre == null) ? 0 : alumno_nombre.hashCode());
		result = prime * result + ((curso_identificador == null) ? 0 : curso_identificador.hashCode());
		result = prime * result + ((curso_nHoras == null) ? 0 : curso_nHoras.hashCode());
		result = prime * result + ((curso_nombre == null) ? 0 : curso_nombre.hashCode());
		result = prime * result + ((curso_profesornombre == null) ? 0 : curso_profesornombre.hashCode());
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
		Imparticion other = (Imparticion) obj;
		if (alumno_apellidos == null) {
			if (other.alumno_apellidos != null)
				return false;
		} else if (!alumno_apellidos.equals(other.alumno_apellidos))
			return false;
		if (alumno_nombre == null) {
			if (other.alumno_nombre != null)
				return false;
		} else if (!alumno_nombre.equals(other.alumno_nombre))
			return false;
		if (curso_identificador == null) {
			if (other.curso_identificador != null)
				return false;
		} else if (!curso_identificador.equals(other.curso_identificador))
			return false;
		if (curso_nHoras == null) {
			if (other.curso_nHoras != null)
				return false;
		} else if (!curso_nHoras.equals(other.curso_nHoras))
			return false;
		if (curso_nombre == null) {
			if (other.curso_nombre != null)
				return false;
		} else if (!curso_nombre.equals(other.curso_nombre))
			return false;
		if (curso_profesornombre == null) {
			if (other.curso_profesornombre != null)
				return false;
		} else if (!curso_profesornombre.equals(other.curso_profesornombre))
			return false;
		return true;
	}
	public String getAlumno_nombre() {
		return alumno_nombre;
	}
	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}
	public String getAlumno_apellidos() {
		return alumno_apellidos;
	}
	public void setAlumno_apellidos(String alumno_apellidos) {
		this.alumno_apellidos = alumno_apellidos;
	}
	public String getCurso_nombre() {
		return curso_nombre;
	}
	public void setCurso_nombre(String curso_nombre) {
		this.curso_nombre = curso_nombre;
	}
	public String getCurso_identificador() {
		return curso_identificador;
	}
	public void setCurso_identificador(String curso_identificador) {
		this.curso_identificador = curso_identificador;
	}
	public String getCurso_nHoras() {
		return curso_nHoras;
	}
	public void setCurso_nHoras(String curso_nHoras) {
		this.curso_nHoras = curso_nHoras;
	}
	public String getCurso_profesornombre() {
		return curso_profesornombre;
	}
	public void setCurso_profesornombre(String curso_profesornombre) {
		this.curso_profesornombre = curso_profesornombre;
	}
}