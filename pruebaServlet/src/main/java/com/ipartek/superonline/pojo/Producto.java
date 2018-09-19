package com.ipartek.superonline.pojo;

public class Producto {

	private String nombre, descripcion;
	private double precio;
	private long ID;
	
	
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String descripcion, double precio, long iD) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		ID = iD;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
