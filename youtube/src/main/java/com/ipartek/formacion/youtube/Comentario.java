package com.ipartek.formacion.youtube;

import java.util.Date;

public class Comentario {
	private long idComentario;
	private String descripcion;
	private Date fecha;

	
	public Comentario(long idComentario, String descripcion, Date fecha) {
		super();
		this.idComentario = idComentario;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public Comentario(String descripcion, Date fecha) {
		this(-1L, descripcion, fecha);
	}

	public long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (idComentario ^ (idComentario >>> 32));
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
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idComentario != other.idComentario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
}
