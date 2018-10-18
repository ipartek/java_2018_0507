package com.ipartek.formacion.bbddyoutube.pojos;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	private String descripcion;
	private Long idUsuario;
	private String nombreUsuario;
	
	// DEFAULT VIDEO
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";	
		this.descripcion = "Descripcion del video de Red Hot Chilli Peppers";
	}
	
	public Video(Long id, String idVideo, String nombre, String descripcion) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}
	
	public Video(Long id, String idVideo, String nombre, String descripcion, Long idUsuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setIdUsuario(idUsuario);
	}

	public Video(Long id, String idVideo, String nombre, String descripcion, String nombreUsuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setNombreUsuario(nombreUsuario);
	}
	
	public Video(String idVideo, String nombre, String descripcion, Long idUsuario) {
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setIdUsuario(idUsuario);
	}
	
	public Video(String idVideo, String nombre, String descripcion) {
		this(-1L, idVideo, nombre, descripcion);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
