package com.ipartek.formacion.bbddyoutube.pojos;

public class Puntuacion {
	private int puntos;
	private Usuario usuario;
	private Video video;
	
	public Puntuacion(int puntos, Usuario usuario, Video video) {
		setPuntos(puntos);
		setUsuario(usuario);
		setVideo(video);
	}

	@Override
	public String toString() {
		return "Puntuacion [puntos=" + puntos + ", usuario=" + usuario + ", video=" + video + "]";
	}
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + puntos;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		Puntuacion other = (Puntuacion) obj;
		if (puntos != other.puntos)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}
	
}
