package com.ipartek.formacion.javaee.libros.modelos;

public class Cabecera {
	private String titulo = "Préstamo de libros";


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
