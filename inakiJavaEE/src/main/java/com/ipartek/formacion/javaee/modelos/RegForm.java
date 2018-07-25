package com.ipartek.formacion.javaee.modelos;

public class RegForm {
private String nombre="",apellidos="",dni="",password="";

public RegForm(String nombre, String apellidos, String dni, String password) {
	super();
	setNombre(nombre);
	setApellidos(apellidos);
	setDni(dni);
	setPassword(password);
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}
