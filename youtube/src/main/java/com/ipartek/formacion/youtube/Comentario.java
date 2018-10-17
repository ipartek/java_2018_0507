package com.ipartek.formacion.youtube;

import java.util.Date;

public class Comentario {
	private int id;
	private String texto;
	private int videoyoutube_id;
	private int usuario_id;
	private Date fecha;
	public Comentario(int id, String texto, int videoyoutube_id, int usuario_id, Date fecha) {
		super();
		this.id = id;
		this.texto = texto;
		this.videoyoutube_id = videoyoutube_id;
		this.usuario_id = usuario_id;
		this.fecha = fecha;
	}
	public Comentario(String texto, int videoyoutube_id, int usuario_id, Date fecha) {
		super();
		this.texto = texto;
		this.videoyoutube_id = videoyoutube_id;
		this.usuario_id = usuario_id;
		this.fecha = fecha;
	}
	public Comentario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getVideoyoutube_id() {
		return videoyoutube_id;
	}
	public void setVideoyoutube_id(int videoyoutube_id) {
		this.videoyoutube_id = videoyoutube_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + usuario_id;
		result = prime * result + videoyoutube_id;
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
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		if (videoyoutube_id != other.videoyoutube_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", videoyoutube_id=" + videoyoutube_id + ", usuario_id="
				+ usuario_id + ", fecha=" + fecha + "]";
	}
	
	
}
