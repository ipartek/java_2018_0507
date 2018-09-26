package com.formacion.ipartek.pojo;

public class HojaLibro {
	String textoHoja="",autor="";
	long id;
	public HojaLibro() {
		
	}
	public HojaLibro(String texto) {
		textoHoja=texto;
	}
	public HojaLibro(long id,String texto,String autor) {
		textoHoja=texto;
		this.autor=autor;
		this.id=id;
	}
	
	public String getTextoHoja() {
		return textoHoja;
	}
	public void setTextoHoja(String textoHoja) {
		this.textoHoja = textoHoja;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((textoHoja == null) ? 0 : textoHoja.hashCode());
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
		HojaLibro other = (HojaLibro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id != other.id)
			return false;
		if (textoHoja == null) {
			if (other.textoHoja != null)
				return false;
		} else if (!textoHoja.equals(other.textoHoja))
			return false;
		return true;
	}
}
