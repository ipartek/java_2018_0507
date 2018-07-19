
package com.ipartek.formacion.libro.pojo;

public class Libro {
	private long id;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private long idCliente;
	
	
	public Libro(long id, String isbn, String titulo, String autor, String editorial, long idCliente) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.idCliente = idCliente;
	}

	public Libro() throws InstantiationException, IllegalAccessException {
		this(-1, "", "","","",-1);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getCliente() {
		return idCliente;
	}

	public void setCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	
	
	
//	@Override
//	public String toString() {
//		return "VideoYoutube [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		VideoYoutube other = (VideoYoutube) obj;
//		if (codigo == null) {
//			if (other.codigo != null)
//				return false;
//		} else if (!codigo.equals(other.codigo))
//			return false;
//		if (id != other.id)
//			return false;
//		if (titulo == null) {
//			if (other.titulo != null)
//				return false;
//		} else if (!titulo.equals(other.titulo))
//			return false;
//		return true;
//	}
//	
//	
//	
	
	

	public boolean isLibre() {
		//TODO: implementar isLibre
		throw new RuntimeException("No implementado");
	} 
}