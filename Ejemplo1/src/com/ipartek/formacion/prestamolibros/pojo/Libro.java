package com.ipartek.formacion.prestamolibros.pojo;

public class Libro {
	public Libro(long id, String isbn, String titulo, String autor, String editorial, Cliente cliente) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.cliente = cliente;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public void setId(long id) {
		this.id = id;
	}



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



	public long getId() {
		// TODO Auto-generated method stub
		return id;
	} 
}
