package com.ipartek.formacion.uf2216.pojo;

public class Revista {
	private long id;
	private String Titulo;
	private String ISBN;
	private long numPaginas;
	private boolean formato;
	//digital = true	papel= false
	
	public Revista() {
		super();
	}
	
	/*public Libro() {
		this(-1, "", "", "", "", false);
	}*/
	
	
	public Revista(long id, String titulo, String iSBN, long numPaginas, boolean formato) {
		super();
		this.id = id;
		Titulo = titulo;
		ISBN = iSBN;
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
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
		return "Revistas [id=" + id + ", Titulo=" + Titulo + ", ISBN=" + ISBN + ", numPaginas=" + numPaginas
				+ ", formato=" + formato + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (numPaginas ^ (numPaginas >>> 32));
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
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		if (formato != other.formato)
			return false;
		if (id != other.id)
			return false;
		if (numPaginas != other.numPaginas)
			return false;
		return true;
	}
	
}
