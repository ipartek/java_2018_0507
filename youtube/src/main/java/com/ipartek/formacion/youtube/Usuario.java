package com.ipartek.formacion.youtube;

public class Usuario {

private Long id;
private String email;
private String nick;
private String password;


public Usuario() {
	super();
	
}

public Usuario(Long id, String email, String nick, String password) {
	super();
	this.id = id;
	this.email = email;
	this.nick = nick;
	this.password = password;
}


public Usuario(String email, String nick, String password) {
	super();
	
	this.email = email;
	this.nick = nick;
	this.password = password;
}


public Usuario(String nick, String password) {
	super();
	this.nick = nick;
	this.password = password;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNick() {
	return nick;
}

public void setNick(String nick) {
	this.nick = nick;
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
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nick == null) ? 0 : nick.hashCode());
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
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nick == null) {
		if (other.nick != null)
			return false;
	} else if (!nick.equals(other.nick))
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
	return "Usuario [id=" + id + ", email=" + email + ", nick=" + nick + ", password=" + password + "]";
}







}
