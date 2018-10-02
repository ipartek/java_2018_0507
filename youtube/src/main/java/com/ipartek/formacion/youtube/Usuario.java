package com.ipartek.formacion.youtube;

public class Usuario {

	public Usuario(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Usuario(String email, String password) {
		super();

		this.email = email;
		this.password = password;
	}

	public Usuario() {
		super();

	}

	private Long id;
	private String email;
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
