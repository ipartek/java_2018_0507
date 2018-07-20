package com.ipartek.formacion.uf2216.pojo;

public class Revista {
	private long id;
	private String titulo;
	private String isbn;
	private long numPaginas;
	private boolean formato;
	//digital = true	papel= false
	
	public Revista() {
	this(-1, "", "", 0, false);
	}

	public Revista(long id, String titulo, String isbn, long numPaginas, boolean formato) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
		this.formato = formato;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(long numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Revista [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numPaginas=" + numPaginas
				+ ", formato=" + formato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + (int) (numPaginas ^ (numPaginas >>> 32));
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
		if (formato != other.formato)
			return false;
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
