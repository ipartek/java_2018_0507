package com.ipartek.formacion.javaee.uf2218.pojo;

public class Usuario {
		
	private long id;
	private String email = "";
	private String password = "";

	private String errorEmail = "";
	private String errorPassword = "";
	
	private boolean correcto = true;
	
	public Usuario() {
		super();
	}

	public Usuario(long id, String email, String password, String errorEmail, String errorPassword, boolean correcto) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.errorEmail = errorEmail;
		this.errorPassword = errorPassword;
		this.correcto = correcto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((errorEmail == null) ? 0 : errorEmail.hashCode());
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
		if (correcto != other.correcto)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (errorEmail == null) {
			if (other.errorEmail != null)
				return false;
		} else if (!errorEmail.equals(other.errorEmail))
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", errorEmail=" + errorEmail
				+ ", errorPassword=" + errorPassword + ", correcto=" + correcto + "]";
	}
	
	
}
