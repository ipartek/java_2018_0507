package com.ipartek.formacion.pojo.supermercado;

public class Usuario {
	private String emailUsuario;
	private String Password;
	
	

	public Usuario(String emailUsuario, String password) {
		super();
		this.emailUsuario = emailUsuario;
		Password = password;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	
	
}
