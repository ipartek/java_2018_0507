package com.ipartek.formacion.supermercado.modelos;

public class Producto {
	private String nombre, descripcion;
	private int precio;
	private long id;

	public Producto() {

	}

	public Producto(long id, int precio, String nombre, String descripcion) {
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}