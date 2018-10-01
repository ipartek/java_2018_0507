package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private String id;
	private String nombre;
	
	public Video() {
		super();
		this.id = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(String id) {
		super();
		this.id = id;
			
	}
	
	public Video(String id, String nombre) throws Exception {
		this();
		this.setId(id);
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
