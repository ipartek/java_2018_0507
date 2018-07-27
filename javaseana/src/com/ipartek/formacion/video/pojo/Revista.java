package com.ipartek.formacion.video.pojo;
/**
 * @class VideoYoutube 
 * 
 * es una clase . Representa un video 
 * @author AnaMAMM
 *
 */
public class Revista {
	
	/**
	 * variables id codigo y titulo
	 */
	private long id;
	private String codigo;
	private String titulo;

	/**
	 * constructor con parametros
	 * @param id
	 * @param codigo
	 * @param titulo
	 */
	public Revista(long id, String codigo, String titulo) {
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
	}

	/**
	 * constructor sin parametros
	 */
	public Revista() {
		this(-1, "", "");
	}

	
	/**
	 * getters y setters
	 * @return
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + "]";
	}

	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
 
	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
