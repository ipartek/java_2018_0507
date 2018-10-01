package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private long id;
	private String idVideo;
	private String nombre;
	
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(String idVideo, String nombre) throws Exception {
		this.setIdVideo(idVideo);
		this.nombre = nombre;
	}
	
	public Video(Long id, String idVideo, String nombre) throws Exception {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.nombre = nombre;
	}

	public String getId() {
		return idVideo;
	}
	public void setId(Long id) throws Exception {
		this.id = id;
	}
	public String getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(String id) throws Exception {
		if ( id != null && id.length() == ID_LONGITUD ) {
			this.idVideo = id;
		}else {
			throw new Exception("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
