package com.ipartek.formacion.prestamoLibro.pojo;



public class Libro {
	private long id;
	private String titulo,autor,editorial,isbn;
	private Cliente cliente;
	private boolean estaLibre=true;
	private Libro() {}
	public Libro(long id, String titulo, String autor, String editorial, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isLibre () {
		
		if(cliente==null)
		
			return false;
		
		else
			return true;
	}
	
	@Override
	public String toString() {
		
			return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn="
				+ isbn + ", cliente=" + "]";
	}

	
}
