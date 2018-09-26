package com.formacion.ipartek.pojo;

public class Usuario {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorEmail == null) ? 0 : errorEmail.hashCode());
		result = prime * result + ((errorPassword == null) ? 0 : errorPassword.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	String usuario="",password="",errorEmail="",errorPassword="",rol="";
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
	
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrorEmail() {
		System.out.println("entroo usuario.getpass"+errorEmail);
		return errorEmail;
	}
	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}
	public String getErrorPassword() {
		System.out.println("entroo usuario.getusu"+errorPassword);
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}

	
	
	public Usuario(long id,String email,String password,String rol) {
		this.id=id;
		this.usuario=email;
		this.password=password;
		this.rol=rol;
	}
	public Usuario(String email,String password) {
		this(-1,email,password);
	}
	public Usuario(long id,String email,String password){
		this.id=id;
		this.usuario=email;
		this.password=password;
	}
	public Usuario(){}
}
