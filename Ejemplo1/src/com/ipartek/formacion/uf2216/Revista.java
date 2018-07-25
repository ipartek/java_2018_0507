package com.ipartek.formacion.uf2216;

public class Revista {

	private long id;
	private String titulo;
	private String isbn;
	private long nPaginas;
	private boolean formato;
	
	public Revista(long id, String titulo, String isbn, long nPaginas, boolean formato) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.nPaginas = nPaginas;
		this.formato = formato;
	}
	
	public Revista() {
		this(-1,"","",-1,false);
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

	public long getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(long nPaginas) {
		this.nPaginas = nPaginas;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}
	
	

	@Override
	public String toString() {
		return "Revista [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", nPaginas=" + nPaginas + ", formato="
				+ formato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + (int) (nPaginas ^ (nPaginas >>> 32));
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
		if (nPaginas != other.nPaginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
}
