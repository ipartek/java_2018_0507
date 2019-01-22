package com.ipartek.examenPablo.libroCompartido.pojo;

public class Usuario implements Identificable {
	private long id;
	private String nombre = ""; 
	private String password = "";

	private String errornombre = "";
	private String errorPassword = "";

	private boolean correcto = true;

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", errornombre=" + errornombre
				+ ", errorPassword=" + errorPassword + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			setErrornombre("No se admite un nombre vacio");

		}

		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrornombre() {
		return errornombre;
	}

	public void setErrornombre(String errornombre) {
		correcto = false;
		this.errornombre = errornombre;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		correcto = false;
		this.errorPassword = errorPassword;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((errornombre == null) ? 0 : errornombre.hashCode());
		result = prime * result + ((errorPassword == null) ? 0 : errorPassword.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (errornombre == null) {
			if (other.errornombre != null)
				return false;
		} else if (!errornombre.equals(other.errornombre))
			return false;
		if (errorPassword == null) {
			if (other.errorPassword != null)
				return false;
		} else if (!errorPassword.equals(other.errorPassword))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public Usuario(long id, String nombre, String password) {
		this.id = id;
		setNombre(nombre);
		setPassword(password);
	}

	public Usuario(String nombre, String password) {
		this(-1, nombre, password);
	}

	public Usuario() {
	}

	public boolean isCorrecto() {
		return correcto;
	}
}
