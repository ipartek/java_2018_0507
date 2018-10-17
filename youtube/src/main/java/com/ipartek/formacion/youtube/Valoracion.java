package com.ipartek.formacion.youtube;

public class Valoracion {
	private int puntos;
	private int videoyoutube_id;
	private int usuario_id;
	public Valoracion(int puntos, int videoyoutube_id, int usuario_id) {
		super();
		this.puntos = puntos;
		this.videoyoutube_id = videoyoutube_id;
		this.usuario_id = usuario_id;
	}
	public Valoracion() {
		super();
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + puntos;
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
		Valoracion other = (Valoracion) obj;
		if (puntos != other.puntos)
			return false;
		if (usuario_id != other.usuario_id)
			return false;
		if (videoyoutube_id != other.videoyoutube_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Valoracion [puntos=" + puntos + ", videoyoutube_id=" + videoyoutube_id + ", usuario_id=" + usuario_id
				+ "]";
	}
	
	
	
}
