package com.ipartek.formacion.uf2216.presentacionconsola;

public class Revista {

	private static final int ISBN_LENGHT = 10;
	private static final String ISBN_EXCEPTION = null;
	private long id;
	private String titulo;
	private String isbn;
	private int numPaginas;
//	private boolean formato;

	public Revista(long id, String titulo, String isbn, int numPaginas) throws Exception {
		super();
		this.id = id;
		this.titulo = titulo;
		setIsbn(isbn);
		this.numPaginas = numPaginas;
		//this.formato = formato;
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

	public void setTitulo(String titulo) throws Exception {
		if (titulo != null) {
			titulo = titulo.trim();
			this.titulo = titulo;
		} else {
			throw new Exception();
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn != null && isbn.trim().length() == ISBN_LENGHT) {
			this.isbn = isbn;
		} else {
			throw new Exception(ISBN_EXCEPTION);
		}
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

//	public boolean isFormato() {
//		return formato;
//	}
//
//	public void setDigital(boolean digital) {
//		this.formato = digital;
//	}

	@Override
	public String toString() {
		return "Revistas [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numPaginas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
//		if (formato != other.formato)
//			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numPaginas != other.numPaginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	

}