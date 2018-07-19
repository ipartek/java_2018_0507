package com.ipartek.formacion.prestamolibros.pojo;

public class Libro {
	private long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private Cliente cliente; //un libro solo puede tener un cliente
	
	public boolean isLibre() { 	
		//TODO: implementar esLibre
		throw new RuntimeException("No implementado");
	}
}
