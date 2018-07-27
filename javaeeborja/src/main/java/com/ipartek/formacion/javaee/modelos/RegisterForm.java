package com.ipartek.formacion.javaee.modelos;

public class RegisterForm {
private  String nombre;
private  String password;
private  String email;
private  String mensajeError;
public RegisterForm(String nombre, String password, String email, String mensajeError) {

	this.nombre = nombre;
	this.password = password;
	this.email = email;
	this.mensajeError = mensajeError;
}
public RegisterForm() {
	// TODO Auto-generated constructor stub
this("", "", "", "");
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
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMensajeError() {
	return mensajeError;
}
public void setMensajeError(String mensajeError) {
	this.mensajeError = mensajeError;
}

	
}
