package com.ipartek.formacion.uf2216.pojo;

public class Revista {

	public Revista(long id, String titulo, int iSBN, int numPag, boolean formato) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ISBN = iSBN;
		this.numPag = numPag;
		this.formato = formato;
	}
	private long id;
	private String titulo;
	private int ISBN;
	private int numPag;
	private boolean formato;
	
	
	
	
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
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public boolean isFormato() {
		return formato;
	}
	public void setFormato(boolean formato) {
		
		this.formato = formato;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return("Revista [id= "+id+", titulo= "+titulo+", ISBN= "+ISBN+", NumPaginas= "+numPag+", formato= "+formato);
	}
	
	
}
