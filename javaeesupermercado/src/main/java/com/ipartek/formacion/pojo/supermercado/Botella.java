package com.ipartek.formacion.pojo.supermercado;

public class Botella {
	
	private long id;
	private String nombre;
	private String tipo;
	private Double precio;
	
	Botella (){
		
	}
	
	
	
	public Botella(long id, String nombre, String tipo, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}





	
	
	
	
}
