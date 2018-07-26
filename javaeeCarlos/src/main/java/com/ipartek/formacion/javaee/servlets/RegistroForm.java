package com.ipartek.formacion.javaee.servlets;

public class RegistroForm {
	private String nombre = "";
	private String apellido = "";
	private String clave = "";
	private String repiteClave = "";
	private String dni = "";
	private String mensajeError;
	private String mensajeErrorUsuario;
	private String mensajeErrorClave;
	private String mensajeErrorRepiteClave;
	private String mensajeErrorApellido;
	private String mensajeErrorNombre;
	private String mensajeErrorDni;

	public RegistroForm(String nombre, String apellido, String clave, String repiteClave, String dni,
			String mensajeError, String mensajeErrorUsuario, String mensajeErrorClave, String mensajeErrorRepiteClave,
			String mensajeErrorApellido, String mensajeErrorNombre, String mensajeErrorDni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
		this.repiteClave = repiteClave;
		this.dni = dni;
		this.mensajeError = mensajeError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.mensajeErrorClave = mensajeErrorClave;
		this.mensajeErrorRepiteClave = mensajeErrorRepiteClave;
		this.mensajeErrorApellido = mensajeErrorApellido;
		this.mensajeErrorNombre = mensajeErrorNombre;
		this.mensajeErrorDni = mensajeErrorDni;
	}

	public RegistroForm(String nombre, String apellido, String clave, String repiteClave, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
		this.repiteClave = repiteClave;
		this.dni = dni;
	}

	public RegistroForm() {
		this("","","","","","","","","","","","");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRepiteClave() {
		return repiteClave;
	}

	public void setRepiteClave(String repiteClave) {
		this.repiteClave = repiteClave;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public String getMensajeErrorUsuario() {
		return mensajeErrorUsuario;
	}

	public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
		this.mensajeErrorUsuario = mensajeErrorUsuario;
	}

	public String getMensajeErrorClave() {
		return mensajeErrorClave;
	}

	public void setMensajeErrorClave(String mensajeErrorClave) {
		this.mensajeErrorClave = mensajeErrorClave;
	}

	public String getMensajeErrorRepiteClave() {
		return mensajeErrorRepiteClave;
	}

	public void setMensajeErrorRepiteClave(String mensajeErrorRepiteClave) {
		this.mensajeErrorRepiteClave = mensajeErrorRepiteClave;
	}

	public String getMensajeErrorApellido() {
		return mensajeErrorApellido;
	}

	public void setMensajeErrorApellido(String mensajeErrorApellido) {
		this.mensajeErrorApellido = mensajeErrorApellido;
	}

	public String getMensajeErrorNombre() {
		return mensajeErrorNombre;
	}

	public void setMensajeErrorNombre(String mensajeErrorNombre) {
		this.mensajeErrorNombre = mensajeErrorNombre;
	}

	public String getMensajeErrorDni() {
		return mensajeErrorDni;
	}

	public void setMensajeErrorDni(String mensajeErrorDni) {
		this.mensajeErrorDni = mensajeErrorDni;
	}
}
