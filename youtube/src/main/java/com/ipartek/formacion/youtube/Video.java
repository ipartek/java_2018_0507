package com.ipartek.formacion.youtube;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private String id;
	private Long l;
	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}
	private String nombre;
	
	public Video() {
		super();
		this.id = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long l, String id, String nombre) throws Exception {
		this();
		this.l=l;
		this.id=id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) throws Exception {
		System.out.println(id + " ---" + id.length());
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
