package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
private String nombre="";
private String password;
private String mensajeError,mensajeEnombre,mensajeEPassword;
private int hayErrores=0,hayErrorNombre=0,fallanAmbos=0;
public LoginForm(String nombre, String password, String mensajeError) {
	super();
	setNombre(nombre);
	setPassword(password);
	setMensajeError(mensajeError);
}
public LoginForm(String nombre, String password) {
	super();
	setNombre(nombre);
	setPassword(password);
}
public LoginForm() {
	
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	if("".equals(nombre)) {
		hayErrorNombre=1;
	}
	else
	this.nombre = nombre;
	
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	if("".equals(password)) {
	hayErrores=1;
	}
	else
	this.password = password;
}
public String getMensajeErrorNombre() {
	if (hayErrorNombre==1)
		mensajeEnombre="el nombre no puede estar en blanco";
	else
		mensajeEnombre="";
	return mensajeEnombre;
}
public String getMensajeErrorPass() {
	if (hayErrores==1)
		mensajeEPassword="el password no puede estar en blanco";
	else
		mensajeEPassword="";
	return mensajeEPassword;
}
public String getMensajeError() {
	if(hayErrores==1 && hayErrorNombre==1)
		setMensajeError("tienes todo blanco");
	else
		setMensajeError("");
	
	//if (hayErrorNombre==1)
	return mensajeError;
}
public void setMensajeError(String mensajeError) {
	this.mensajeError = mensajeError;
}
@Override
public String toString() {
	return "LoginForm [nombre=" + nombre + ", password=" + password + ", mensajeError=" + mensajeError + "]";
}

}
