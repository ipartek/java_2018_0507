package com.ipartek.javaeeEjercicios.pojos;

public class Producto {

	private static long ID = 0;
	private String nombre;
	private String categoria;
	private String descripcion;
	private int precio;
	private int decimal;
	private int descuento;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String nombre, String categoria, String descripcion, int precio, int decimal, int descuento) {
		super();
		ID += 1;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.decimal = decimal;
		this.descuento = descuento;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public long getId() {
		return ID;
	}

	
	
}
