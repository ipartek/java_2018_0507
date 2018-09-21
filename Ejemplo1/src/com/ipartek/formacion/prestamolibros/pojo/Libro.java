package com.ipartek.formacion.prestamolibros.pojo;

//TODO: Quitar el @SuppressWarnings("unused")
@SuppressWarnings("unused")
public class Libro {
	private long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private Cliente cliente; //un libro solo puede tener un cliente
	
	public Libro(long id, String isbn, String titulo, String autor, String editorial) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
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
	
	public long getId() {
		return 0;
	}

	public boolean isLibre() {
		if(cliente==null)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial="
				+ editorial + ", cliente=" + cliente + "]";
	}
}
