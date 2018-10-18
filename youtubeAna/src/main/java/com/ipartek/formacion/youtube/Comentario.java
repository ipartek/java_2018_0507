package com.ipartek.formacion.youtube;

public class Comentario {

	public static final int ID_LONGITUD = 11;
	
	private String usuario;
	private String comentario;
	
	
	public Comentario() {
		super();
		this.usuario = "ByDefault";		
		this.comentario = "ByDefault";
		
	}
	
	public Comentario(String usuario,String comentario) {
		this.setUsuario(usuario);
		this.setComentario(comentario);
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getComentario() {
		return comentario;
	}

}
