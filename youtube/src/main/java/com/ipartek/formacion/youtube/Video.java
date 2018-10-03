package com.ipartek.formacion.youtube;

public class Video {

	public static final int CODIGO_LONGITUD = 11;
	
	private int id;
	private String codigo;
	private String nombre;
	private int idUsuario;
	public Video() {
		super();
		this.codigo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
		this.idUsuario = 1;
	}
	
	public Video(int id, String codigo, String nombre) throws Exception {
		this();
		this.id = id;
		this.setCodigo(codigo);
		this.nombre = nombre;
	}
	public Video(int id, String codigo, String nombre, int idUsuario) throws Exception {
		this();
		this.id = id;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.setIdUsuario(idUsuario);
	}
	public int getId() {
		return id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if ( codigo != null && codigo.length() == CODIGO_LONGITUD ) {
			this.codigo = codigo;
		}else {
			throw new Exception("El Codigo debe ser exactamente de " + CODIGO_LONGITUD + " caracteres");
		}	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	
	
	
	
}
