package com.ipartek.formacion.prestamolibrosspring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Libro {
	
	@NotNull
    @Size(min=2, max=30)
	private String titulo;
	
	//@NotNull
    //@Size(min=2, max=30)
	private String editorial;
	//@NotNull
    //@Size(min=2, max=30)
	private Long isbn;
	
	private Integer idlibro;
	
	public Libro(String titulo, String editorial,
			Long isbn, Integer idlibro) {
		super();
		this.titulo = titulo;
		this.editorial = editorial;
		this.isbn = isbn;
		this.idlibro = idlibro;
	}
	
	public int getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(Integer idlibro) {
		this.idlibro = idlibro;
	}
	public int getId() {
		return idlibro;
	}
	public void setId(int idlibro) {
		this.idlibro = idlibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
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
		Libro other = (Libro) obj;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (isbn != other.isbn)
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
		return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", isbn=" + isbn + ", idlibro=" + idlibro + "]";
	}

}
