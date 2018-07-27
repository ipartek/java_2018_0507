package com.ipartek.formacion.javaee.modelos;

import java.util.ArrayList;

public class LoginForm {
	private String nombre;
	private String password;
	private String mensajeError;
	static ArrayList<LoginForm> lista=new ArrayList<LoginForm>();
	public static ArrayList<LoginForm> getLista() {
		return lista;
	}

	public static void setLista(ArrayList<LoginForm> lista) {
		LoginForm.lista = lista;
	}

	public LoginForm(String nombre, String password, String mensajeError) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.mensajeError = mensajeError;
	}

	public LoginForm(String nombre, String password) {
		this(nombre, password, "");
	}

	public LoginForm() {
		this("", "", "");
	}
	@Override
	public String toString() {
		return "LoginForm [nombre=" + nombre + ", password=" + password + ", mensajeError=" + mensajeError + "]";
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

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
