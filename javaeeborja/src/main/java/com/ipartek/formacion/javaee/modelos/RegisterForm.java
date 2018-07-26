package com.ipartek.formacion.javaee.modelos;

public class RegisterForm {

private String nombrer;
private String passwordr;
private String emailr;
private String mensajeError;

public RegisterForm() {
	
}


public RegisterForm(String nombre, String password, String email,String mensajeError) {
	super();
	this.nombrer = nombre;
	this.passwordr = password;
	this.emailr = email;
	this.mensajeError=mensajeError;
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}





	public String getNombrer() {
		return nombrer;
	}
	public void setNombre(String nombrer) {
		this.nombrer = nombrer;
	}
	public String getPasswordr() {
		return passwordr;
	}
	public void setPassword(String passwordr) {
		this.passwordr = passwordr;
	}
	public String getEmailr() {
		return emailr;
	}
	public void setEmail(String emailr) {
		this.emailr = emailr;
	}


	public String getMensajeError() {
		return mensajeError;
	}


	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	
	
}
