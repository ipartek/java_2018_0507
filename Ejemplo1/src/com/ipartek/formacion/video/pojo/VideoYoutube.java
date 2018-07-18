package com.ipartek.formacion.video.pojo;

public class VideoYoutube {

	private long id;
	private String codigo;
	private String titulo;
	
	
	
	
	public VideoYoutube() { //Utilizando el constructor de abajo vale con esto
		this(-1,"","");

	}
	
	public VideoYoutube(long id, String codigo, String titulo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
