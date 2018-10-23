package com.ipartek.formacion.bbddyoutube.pojos;

import java.util.Date;

public class Comentario {
	private Long id;
	private Long idVideo;
	private Long idUsuario;
	private String texto;
	private Date fecha;
	private String nombre;
	
	public Comentario() {
	}
	
	public Comentario(Long id, Long idVideo, Long idUsuario, String texto, Date fecha) {
		setId(id);
		setIdVideo(idVideo);
		setIdUsuario(idUsuario);
		setTexto(texto);
		setFecha(fecha);
	}

	public Comentario(Long id, Long idVideo, Long idUsuario, String texto, Date fecha, String nombre) {
		setId(id);
		setIdVideo(idVideo);
		setIdUsuario(idUsuario);
		setTexto(texto);
		setFecha(fecha);
		setNombre(nombre);
	}
	
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", idVideo=" + idVideo + ", idUsuario=" + idUsuario + ", texto=" + texto
				+ ", fecha=" + fecha + "]";
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdVideo() {
		return idVideo;
	}


	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((idVideo == null) ? 0 : idVideo.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

}
