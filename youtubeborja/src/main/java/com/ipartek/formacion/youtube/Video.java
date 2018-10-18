package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	private long idUsuario;
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long id, String idVideo, String nombre,long idUsuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setIdUsuario(idUsuario);
	}
	
	public Video(String idVideo, String nombre,long idUsuario ) {
		this(-1L, idVideo, nombre,idUsuario);
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
