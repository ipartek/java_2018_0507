package com.ipartek.formacion.javaee.libros.modelo;

public class Cabecera {
	private String titulo = "Libro";

	public Cabecera() {
		
	}
	
	public Cabecera(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
}
}
