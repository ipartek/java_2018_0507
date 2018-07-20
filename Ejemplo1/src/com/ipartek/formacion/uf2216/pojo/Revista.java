package com.ipartek.formacion.uf2216.pojo;

public class Revista {
	private long id;
	private String titulo;
	private Integer isbn;
	private Integer paginas;
	private Boolean formato;

	
	public Revista(long id, int isbn, String titulo, int paginas, boolean formato) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.paginas = paginas;
		this.formato = formato;
	}

	public Revista() throws InstantiationException, IllegalAccessException {
		this(-1,-1,"",-1,false);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getFormato() {
		if (formato) return "Digital"; else return "Papel";
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
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