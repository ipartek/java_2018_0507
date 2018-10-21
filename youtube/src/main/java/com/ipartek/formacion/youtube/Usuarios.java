package com.ipartek.formacion.youtube;

import java.sql.Date;

public class Usuarios {
	
	private long id;
	private String email;
	private String password;
	private Comentario coment = null;
	
	
	public Usuarios(long id, String email, Comentario coment) {
		super();
		this.id = id;
		this.email = email;
		this.coment = coment;
	}
	public Usuarios(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public Usuarios(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Usuarios(String email, Comentario com) {
		this.email = email;
		this.coment = com;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Usuarios other = (Usuarios) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
	public Comentario getComent() {
		return coment;
	}
	public void setComent(Comentario coment) {
		this.coment = coment;
	}
	
	
	
	
	
}
