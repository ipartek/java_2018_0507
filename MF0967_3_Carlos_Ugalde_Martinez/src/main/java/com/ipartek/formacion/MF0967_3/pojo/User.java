package com.ipartek.formacion.MF0967_3.pojo;

public class User {
	private int idUser;
	private String nombre;
	private String clave;
	
	private String errorNombre = "";
	private String errorClave = "";
	public User(int idUser, String nombre, String clave, String errorNombre, String errorClave) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.clave = clave;
		this.errorNombre = errorNombre;
		this.errorClave = errorClave;
	}
	public User(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}
	public User(int idUser,String nombre, String clave) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.clave = clave;
	}
	public User() {
		super();
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getErrorNombre() {
		return errorNombre;
	}
	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}
	public String getErrorClave() {
		return errorClave;
	}
	public void setErrorClave(String errorClave) {
		this.errorClave = errorClave;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((errorClave == null) ? 0 : errorClave.hashCode());
		result = prime * result + ((errorNombre == null) ? 0 : errorNombre.hashCode());
		result = prime * result + idUser;
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
		User other = (User) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (errorClave == null) {
			if (other.errorClave != null)
				return false;
		} else if (!errorClave.equals(other.errorClave))
			return false;
		if (errorNombre == null) {
			if (other.errorNombre != null)
				return false;
		} else if (!errorNombre.equals(other.errorNombre))
			return false;
		if (idUser != other.idUser)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nombre=" + nombre + ", clave=" + clave + ", errorNombre=" + errorNombre
				+ ", errorClave=" + errorClave + "]";
	}
	
	
}
