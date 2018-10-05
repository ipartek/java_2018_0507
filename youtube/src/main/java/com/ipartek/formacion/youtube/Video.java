package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
<<<<<<< HEAD
	private String id;
	private Long l;
	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}
=======
	private Long id;
	private String idVideo;
>>>>>>> refs/remotes/origin/master
	private String nombre;
	
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
<<<<<<< HEAD
	public Video(Long l, String id, String nombre) throws Exception {
		this();
		this.l=l;
		this.id=id;
		this.nombre = nombre;
=======
	public Video(Long id, String idVideo, String nombre) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
	}
	
	public Video(String idVideo, String nombre ) {
		this(-1L, idVideo, nombre);
>>>>>>> refs/remotes/origin/master
	}

	public Long getId() {
		return id;
	}
<<<<<<< HEAD
	public void setId(String id) throws Exception {
		System.out.println(id + " ---" + id.length());
		if ( id != null && id.length() == ID_LONGITUD ) {
			this.id = id;
		}else {
			throw new Exception("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
=======
	
	public void setId(Long id) {
		this.id = id;
>>>>>>> refs/remotes/origin/master
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
