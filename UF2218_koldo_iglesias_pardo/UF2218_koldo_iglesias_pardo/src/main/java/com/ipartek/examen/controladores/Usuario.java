package com.ipartek.examen.controladores;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Usuario")
public class Usuario implements Identificable {
	private long id;
	private String user = "";
	private String pass = "";
	private boolean correcto = true;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (id != other.id)
			return false;
		if (pass == null) {
			if (other.pass!= null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", pass=" + pass  + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Usuario(long id, String user, String pass) {
		this.id = id;
		setUser(user);
		setPass(pass);
	}

	public Usuario(String email, String password) {
		this(-1, email, password);
	}
	
	public boolean isCorrecto() {
		return correcto;
	}
}
