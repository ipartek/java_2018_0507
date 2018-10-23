package com.ipartek.formacion.bbddyoutube.pojos;

public class Puntuacion {
	private int puntos;
	private Long idUsuario;
	private Long idVideo;
	
	public Puntuacion(int puntos, Long idUsuario, Long idVideo) {
		setPuntos(puntos);
		setIdUsuario(idUsuario);
		setIdVideo(idVideo);
	}

	@Override
	public String toString() {
		return "Puntuacion [puntos=" + puntos + ", idUsuario=" + idUsuario + ", idVideo=" + idVideo + "]";
	}
	
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(long idVideo) {
		this.idVideo = idVideo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + puntos;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((idVideo == null) ? 0 : idVideo.hashCode());
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
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (idVideo == null) {
			if (other.idVideo != null)
				return false;
		} else if (!idVideo.equals(other.idVideo))
			return false;
		return true;
	}
	
}
