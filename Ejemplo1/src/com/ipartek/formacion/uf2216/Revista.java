package com.ipartek.formacion.uf2216;

public class Revista {
	@Override
	public String toString() {
		return "Revista [id=" + id + ", Titulo=" + Titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas
				+ ", format=" + format + "]";
	}
	private long id;
	private String Titulo;         	// tamaño mínimo 3 letras, máximo 150
	private String isbn; 			//longitud 10
	private int numPaginas;             
	private boolean format;			// true == digital     false == papel
	public Revista() {};
	public Revista(long id,String Titulo,String isbn,int numPaginas,boolean format) {
		this.id=id;
		this.Titulo=Titulo;
		this.isbn=isbn;
		this.numPaginas=numPaginas;
		this.format=format;
	}
	public String getTitulo() {
		return Titulo;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public boolean isFormat() {
		return format;
	}
	public void setFormat(boolean format) {
		this.format = format;
	}
	public Revista(String titulo, String isbn, int numPaginas, boolean format) {
		super();
		Titulo = titulo;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.format = format;
	}

}
