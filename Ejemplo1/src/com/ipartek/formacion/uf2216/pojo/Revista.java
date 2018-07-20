package com.ipartek.formacion.uf2216.pojo;

public class Revista {
	private String titulo;
	private int isbn;
	private int numeroPaginas;
	private boolean formato;
	private int id;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public boolean isFormato() {
		return formato;
	}
	public void setFormato(boolean formato) {
		this.formato = formato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + isbn;
		result = prime * result + numeroPaginas;
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
		if (isbn != other.isbn)
			return false;
		if (numeroPaginas != other.numeroPaginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numeroPaginas=" + numeroPaginas + ", formato="
				+ formato + ", id=" + id + "]";
	}
	public Revista(String titulo, int isbn, int numeroPaginas, boolean formato, int id) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numeroPaginas = numeroPaginas;
		this.formato = formato;
		this.id = id;
	}

	
	
}
