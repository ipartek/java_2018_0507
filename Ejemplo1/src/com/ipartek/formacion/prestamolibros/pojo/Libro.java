package com.ipartek.formacion.prestamolibros.pojo;

//TODO: Quitar el @SuppressWarnings("unused")
@SuppressWarnings("unused")
public class Libro {
	private long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private Cliente cliente;
	
	public boolean isLibre() {
		//TODO: implementar isLibre
		throw new RuntimeException("No implementado");
	} 
}
