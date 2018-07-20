package com.ipartek.formacion.uf2216.RevistaPojo;

public class Revista {
private String titulo;
private String isbn;
private int numPaginas=0;
private long id;
private boolean digital=false;//true=digital

	
	@SuppressWarnings("unused")
	private Revista() {
		
	}
	
	public Revista(long id,String titulo, String isbn, int numPaginas, boolean digital) {
	super();
	this.id=id;
	this.titulo = titulo;
	this.isbn = isbn;
	this.numPaginas = numPaginas;
	this.digital = digital;
}
	public String getIsbn() {
		return isbn;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public boolean isDigital() {
		return digital;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}
	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas + "]";
	}


}
