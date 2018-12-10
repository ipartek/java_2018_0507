package com.ipartek.formacion.GestionIncidencias.modelos;

import java.util.Date;

public class Incidencia {
	private Long id;
	private Date fecha;
	private Long usuarioCreador;
	private String titulo;
	private String descripcion;
	private Long usuarioAsignado;
	
	public Incidencia() {
		// TODO Auto-generated constructor stub
	}

	public Incidencia(Long id, Date fecha, Long usuarioCreador, String titulo, String descripcion,
			Long usuarioAsignado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuarioCreador = usuarioCreador;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.usuarioAsignado = usuarioAsignado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Long usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(Long usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuarioAsignado == null) ? 0 : usuarioAsignado.hashCode());
		result = prime * result + ((usuarioCreador == null) ? 0 : usuarioCreador.hashCode());
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
		Incidencia other = (Incidencia) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuarioAsignado == null) {
			if (other.usuarioAsignado != null)
				return false;
		} else if (!usuarioAsignado.equals(other.usuarioAsignado))
			return false;
		if (usuarioCreador == null) {
			if (other.usuarioCreador != null)
				return false;
		} else if (!usuarioCreador.equals(other.usuarioCreador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Incidencia [id=").append(id).append(", fecha=").append(fecha).append(", usuarioCreador=")
				.append(usuarioCreador).append(", titulo=").append(titulo).append(", descripcion=").append(descripcion)
				.append(", usuarioAsignado=").append(usuarioAsignado).append("]");
		return builder.toString();
	}
}
