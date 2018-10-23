package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private Long id;
	private String idVideo;
	private String nombre;
	
	private Usuario usuario;
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	private List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();
	
	public Video() {
		super();
		this.idVideo = "YlUKcNNmywk";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}
	
	public Video(Long id, String idVideo, String nombre, Usuario usuario) {
		this.setId(id);
		this.setIdVideo(idVideo);
		this.setNombre(nombre);
		this.setUsuario(usuario);
	}
	
	public Video(String idVideo, String nombre, Usuario usuario ) {
		this(-1L, idVideo, nombre, usuario);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		if ( idVideo != null && idVideo.length() == ID_LONGITUD ) {
			this.idVideo = idVideo;
		}else {
			throw new RuntimeException("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
		this.idVideo = idVideo;
	}

	public List<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(List<Puntuacion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idVideo == null) ? 0 : idVideo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idVideo == null) {
			if (other.idVideo != null)
				return false;
		} else if (!idVideo.equals(other.idVideo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", idVideo=" + idVideo + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}
}
