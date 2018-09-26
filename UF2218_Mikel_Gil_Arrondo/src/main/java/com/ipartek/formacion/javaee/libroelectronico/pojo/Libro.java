package com.ipartek.formacion.javaee.libroelectronico.pojo;

public class Libro implements Identificable {
	private long id;
	private static long totalid;
	private String texto = "";
	private String autor = "";
	
	private String errorTexto = "";
	
	private boolean correcto = true;
	
	public Libro() {
		totalid++;
	}
	
	public Libro(long id, String texto, String autor) {
		this.id = id;
		setTexto(texto);
		setAutor(autor);
		totalid++;
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
	
	public long getTotalid() {
		return totalid;
	}

	public void setTotalid(long totalid) {
		Libro.totalid = totalid;
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

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorTexto() {
		return errorTexto;
	}

	public void setErrorTexto(String errorTexto) {
		correcto = false;
		this.errorTexto = errorTexto;
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
