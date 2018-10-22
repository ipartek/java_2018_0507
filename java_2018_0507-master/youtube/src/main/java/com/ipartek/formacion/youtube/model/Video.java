package com.ipartek.formacion.youtube.model;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long id, String idVideo, String nombre, Usuario usuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setUsuario(usuario);
	}
	
	public Video(String idVideo, String nombre, Usuario usuario ) {
		this(-1L, idVideo, nombre, usuario);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		if ( idVideo != null && idVideo.length() == ID_LONGITUD ) {
			this.idVideo = idVideo;
		}else {
			throw new RuntimeException("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
		this.idVideo = idVideo;
	}
	
	
	
}
