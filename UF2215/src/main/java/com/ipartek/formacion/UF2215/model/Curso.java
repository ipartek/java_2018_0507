package com.ipartek.formacion.UF2215.model;


public class Curso {
	private Long codigo;
	private String nombre, identificador, nHoras,profesor_codigo;
	
	public Curso(Long codigo, String nombre, String identificador, String nHoras, String profesor_codigo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.identificador = identificador;
		this.nHoras = nHoras;
		this.profesor_codigo = profesor_codigo;
	}
	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", nHoras="
				+ nHoras + ", profesor_codigo=" + profesor_codigo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((nHoras == null) ? 0 : nHoras.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor_codigo == null) ? 0 : profesor_codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nHoras == null) {
			if (other.nHoras != null)
				return false;
		} else if (!nHoras.equals(other.nHoras))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor_codigo == null) {
			if (other.profesor_codigo != null)
				return false;
		} else if (!profesor_codigo.equals(other.profesor_codigo))
			return false;
		return true;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public String getnHoras() {
		return nHoras;
	}
	public void setnHoras(String nHoras) {
		this.nHoras = nHoras;
	}
	public String getProfesor_codigo() {
		return profesor_codigo;
	}
	public void setProfesor_codigo(String profesor_codigo) {
		this.profesor_codigo = profesor_codigo;
	}

	
}