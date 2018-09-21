package com.ipartek.formacion.pojo;

public class Usuario {
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
		return errorEmail;
	}
	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}
	public String getErrorPassword() {
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}
	long id;
	String usuario="",password="",errorEmail="",errorPassword="";
	
	public Usuario(long id,String email,String password) {
	this.id=id;
		this.usuario=email;
		this.password=password;
	}
	public Usuario(String email,String password) {
		this(-1,email,password);
	}
	public Usuario(){}
}
