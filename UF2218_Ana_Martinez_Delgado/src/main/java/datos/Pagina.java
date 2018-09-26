package datos;

import java.util.List;

public class Pagina {

	public String contenido;
	public String autor;
	public int idPag;
	public List<Pagina> lista;
	
	public Pagina(int idPag, String contenido, String autor) {
		super();
		this.idPag = idPag;
		this.contenido = contenido;
		this.autor = autor;
	}
	
	public List addaLista(int idPag, String contenido, String autor){
		Pagina pagi=new Pagina(idPag,contenido,autor);
		lista.add(pagi);
		return lista;
	}
	public List getLista() {
		return lista;
	}
	public Pagina() {
		// TODO Auto-generated constructor stub
	}
	public int getIdPag() {
		return idPag;
	}
	public void setIdPag(int idPag) {
		this.idPag = idPag;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + idPag;
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
		Pagina other = (Pagina) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (idPag != other.idPag)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagina [idPag=" + idPag + ", contenido=" + contenido + ", autor=" + autor + "]";
	}
}
