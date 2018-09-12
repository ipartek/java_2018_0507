package com.ipartek.formacion.javaee.libros.modelos;

public class Libro {
	public Libro(int iD, String titulo, String editorial, int precio) {
		super();
		ID = iD;
		this.titulo = titulo;
		this.editorial = editorial;
		this.precio = precio;
	}
	
	public Libro() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	private int ID;
	private String titulo;
	private String editorial;
	private int precio;
	public static void main(String[] args) {
		// TODO Auto-generated method stub




		
	}

}
