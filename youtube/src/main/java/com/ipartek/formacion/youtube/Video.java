package com.ipartek.formacion.youtube;

public class Video {
	private String id;
	private String nombre;
	
	public static final int ID_LONGITUD = 11;
	private String idvideo;
	public String getIdvideo() {
		return idvideo;
	}

	public Video(String id, String nombre, String idvideo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idvideo = idvideo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static int getIdLongitud() {
		return ID_LONGITUD;
	}

	
	public Video() {
		super();
		this.idvideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(String id, String nombre) throws Exception {
		this();
		this.setIdvideo(id);
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}
	public void setIdvideo(String idvideo) throws Exception {
		if ( idvideo != null && idvideo.length() == ID_LONGITUD ) {
			this.idvideo = idvideo;
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
