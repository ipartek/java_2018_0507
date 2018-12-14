package com.ipartek.formacion.springrestcrud.entidades;

public class Comentario {

	private long id;
	private long id_incidencia;
	private String usuario;
	private String comentario;
	private String fecha;
	
	public Comentario() {}
	
	public Comentario(long id, long id_incidencia, String usuario, String comentario, String fecha) {
		super();
		this.id = id;
		this.id_incidencia = id_incidencia;
		this.usuario = usuario;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", id_incidencia=" + id_incidencia + ", usuario=" + usuario + ", comentario="
				+ comentario + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (id_incidencia ^ (id_incidencia >>> 32));
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Comentario other = (Comentario) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (id_incidencia != other.id_incidencia)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(long id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
}