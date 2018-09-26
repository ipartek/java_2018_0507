package com.ipartek.formacion.javaee.libroelectronico.pojo;

public class Libro {
	private long id;
	private String texto = "";
	private String autor = "";
	
	public Libro() {
	}
	
	public Libro(long id, String texto, String autor) {
		this.id = id;
		this.texto = texto;
		this.autor = autor;
	}
	
	public Libro(String texto, String autor) {
		this(-1, texto, autor);
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", texto=" + texto + ", autor=" + autor + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

}
