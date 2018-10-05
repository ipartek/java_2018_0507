package com.ipartek.formacion.bbddyoutube.pojos;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	private Long idUsuario;
	private String nombreUsuario;
	
	// DEFAULT VIDEO
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long id, String idVideo, String nombre) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
	}
	
	public Video(Long id, String idVideo, String nombre, Long idUsuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setIdUsuario(idUsuario);
	}

	public Video(Long id, String idVideo, String nombre, String nombreUsuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setNombreUsuario(nombreUsuario);
	}
	
	public Video(String idVideo, String nombre, Long idUsuario) {
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setIdUsuario(idUsuario);
	}
	
	public Video(String idVideo, String nombre ) {
		this(-1L, idVideo, nombre);
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
