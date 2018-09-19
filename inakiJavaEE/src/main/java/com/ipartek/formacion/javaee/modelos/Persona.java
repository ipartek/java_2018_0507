package com.ipartek.formacion.javaee.modelos;

public class Persona {
private String nombre="";
private String password,passwordIwales,dni,apellido,passFinal;
private String mensajeError,mensajeEnombre,mensajeEPassword;
private int hayErrores=0,hayErrorNombre=0,fallanAmbos=0,errorApellido=0,errorDni=0,errorPassIwales=0;
public int x;
private char[] arrayDni={'t','r','w','a','g','m','y','f','p','d','x','b','n','j','z','s','q','v','h','l','c','k','e'};
public Persona(String nombre, String password, String mensajeError) {
	super();
	setNombre(nombre);
	setPassword(password);
	setMensajeError(mensajeError);
}
public Persona(String nombre, String password) {
	super();
	setNombre(nombre);
	setPassword(password);
}
public Persona() {
	
}
public Persona(String nombre,String apellidos,String dni,String password,String repPass){//para registrar una persona {
	
	super();
	setNombre(nombre);
	setApellido(apellidos);
	setDni(dni);
	setPassword(password);
	if(repPass!="" && repPass!=null && password!="" && password!=null)
	setPasswordIwales(repPass);
	//System.out.println(nombre+apellidos+dni);
	
}
public String getPasswordIwales() {
	return passwordIwales;
}
public void setPasswordIwales(String passwordIwales) {
	if(!password.equals(passwordIwales)&& passwordIwales!="")
		errorPassIwales=1;
	else {
	passFinal=passwordIwales;
	this.passwordIwales = passwordIwales;
	}
}

public String getErrorCompPass()
{
	String error="";
	if(errorPassIwales==1)
		error="no coindiden";
	else 
		error="";
	return error;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	System.out.println(dni);
	try {
		if(dni.length()==9) {
			int numero=Integer.parseInt(dni.substring(0, 8))%23;
			System.out.println(numero + "miNum");
			if (!(dni.charAt(9)==arrayDni[numero]))
			{
				errorDni=4;
			}
		}
		else errorDni=3;
	} catch (NumberFormatException e) {
		errorDni=3;
		// TODO: handle exception
	}
	
	if(!(dni.length()==9))
		errorDni=1;
	if(dni.length()==9) {
	if(Character.isDigit(dni.charAt(8)))
		errorDni=2;
	}		
	else
	this.dni = dni;
}
public String getDniError() {
	String error="";
	if(errorDni==1)
		error="no cumple la longitud";
	if (errorDni==2)
		error="necesito una letra";
	if(errorDni==3)
		error="8 numero y una letra";
	if(errorDni==4)
		error="no coincide ese numero kon la letra";		
	return error;
}
public String getApellido() {
	if(apellido=="") {
		apellido="no puede estar vacio payo";
	}
	else
		apellido="";
	System.out.println(apellido);
	return apellido;
}
public String getApellidoE(){
	String error="";
	if(errorApellido==1)
		error="vacios no";
	else
		error="";
		
	
	return error;
}
public void setApellido(String apellido) {
	if("".equals(apellido))
		errorApellido=1;
		else
	this.apellido = apellido;
	
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
	System.out.println(hayErrorNombre+"mis errores"+x);
	if (hayErrorNombre==1) {
		mensajeEnombre="el nombre no puede estar en blanco";
	}
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
