package com.ipartek.formacion.youtube;

public class Video {
	private String id;
	private String nombre;
	
	public static final int ID_LONGITUD = 11;
	private String idvideo;
	public String getIdvideo() {
		return idvideo;
	}

	public void setIdvideo(String idvideo) {
		this.idvideo = idvideo;
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
	public void setId(String id) throws Exception {
		if ( id != null && id.length() == ID_LONGITUD ) {
			this.id = id;
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
