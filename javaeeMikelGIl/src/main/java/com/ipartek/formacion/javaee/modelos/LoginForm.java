package com.ipartek.formacion.javaee.modelos;

public class LoginForm {
	private String nombre = "";
	private String password = "";
	private String apellido = "";
	private String dni = "";
	private String email = "";
	
	private String mensajeError = "";
	
	private String errorNombre = "";
	private String errorApellido = "";
	private String errorPassword = "";
	private String errorDni = "";
	private String errorEmail = "";
	
	private boolean erroneo = false;
	
	private static final String DNI_REGEX = "^((([A-Z]|[a-z])\\d{8})|(\\d{8}([A-Z]|[a-z])))$";
	private static final String EMAIL_REGEX = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

	// OBLIGATORIO PARA PODER USAR <jsp:useBean
	public LoginForm() {
	}

	@Override
	public String toString() {
		return "LoginForm [nombre=" + nombre + ", password=" + password + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre){
		if (nombre == null || nombre.trim().length() == 0) {
			setErrorNombre("Es obligatorio rellenar el nombre");
			setErroneo(true);
			throw new LoginFormException("Es obligatorio rellenar el nombre");
		}
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido == null || apellido.trim().length() == 0) {
			setErrorApellido("Es obligatorio rellenar el apellido");
			setErroneo(true);
			throw new LoginFormException("Es obligatorio rellenar el apellido");
		}
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.trim().length() == 0) {
			setErrorPassword("Es obligatorio rellenar el password");
			setErroneo(true);
			throw new LoginFormException("Es obligatorio rellenar el password");
		}
		this.password = password;
	}
	
	public boolean compararPassword(String password, String passwordRepeat) {
		if (!password.equals(passwordRepeat)) {
			setErroneo(true);
			return false;
		}
		return true;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (!dni.matches(DNI_REGEX)) {
			setErrorDni("Introduce un dni valido");
			setErroneo(true);
			throw new LoginFormException("Introduce un dni valido");
		}
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!email.matches(EMAIL_REGEX)) {
			setErrorEmail("Introduce un email valido");
			setErroneo(true);
			throw new LoginFormException("Introduce un email valido");
		}
		this.email = email;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		this.errorNombre = errorNombre;
	}
	public String getErrorApellido() {
		return errorApellido;
	}
	public void setErrorApellido(String errorApellido) {
		this.errorApellido = errorApellido;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}

	public String getErrorDni() {
		return errorDni;
	}

	public void setErrorDni(String errorDni) {
		this.errorDni = errorDni;
	}

	public String getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

	public boolean isErroneo() {
		return erroneo;
	}

	public void setErroneo(boolean erroneo) {
		this.erroneo = erroneo;
	}
	
}	
