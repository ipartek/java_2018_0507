package com.ipartek.formacion.youtube;

import java.util.Date;

public class Comentario {

	public static final int ID_LONGITUD = 11;
	
	private String usuario;
	private String texto;
	public long id;
	public Date fecha;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Comentario() {
		super();
		this.usuario = "ByDefault";		
		this.texto = "ByDefault";
		
	}
	
	public Comentario(String usuario,String texto) {
		this.setUsuario(usuario);
		this.setTexto(texto);
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}

}
