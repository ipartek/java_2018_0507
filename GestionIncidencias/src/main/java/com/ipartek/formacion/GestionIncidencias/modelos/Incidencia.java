package com.ipartek.formacion.GestionIncidencias.modelos;

import java.util.Date;

public class Incidencia {
	private Long id;
	private Date fecha;
	private Usuario usuarioCreador;
	private String titulo;
	private String descripcion;
	private Usuario usuarioAsignado;
	
	private Long usuarioCreadorId;
	private Long usuarioAsignadoId;
	
	public Incidencia() {
		// TODO Auto-generated constructor stub
	}

	public Incidencia(Long id, Date fecha, Usuario usuarioCreador, String titulo, String descripcion,
			Usuario usuarioAsignado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuarioCreador = usuarioCreador;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.usuarioAsignado = usuarioAsignado;
	}
	
	public Incidencia(Long id, Date fecha, String titulo, String descripcion, Long usuarioCreadorId,
			Long usuarioAsignadoId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.usuarioCreadorId = usuarioCreadorId;
		this.usuarioAsignadoId = usuarioAsignadoId;
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

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
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

	public Usuario getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(Usuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}
	
	public Long getUsuarioCreadorId() {
		return usuarioCreadorId;
	}

	public void setUsuarioCreadorId(Long usuarioCreadorId) {
		this.usuarioCreadorId = usuarioCreadorId;
	}

	public Long getUsuarioAsignadoId() {
		return usuarioAsignadoId;
	}

	public void setUsuarioAsignadoId(Long usuarioAsignadoId) {
		this.usuarioAsignadoId = usuarioAsignadoId;
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
		result = prime * result + ((usuarioAsignadoId == null) ? 0 : usuarioAsignadoId.hashCode());
		result = prime * result + ((usuarioCreador == null) ? 0 : usuarioCreador.hashCode());
		result = prime * result + ((usuarioCreadorId == null) ? 0 : usuarioCreadorId.hashCode());
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
		if (usuarioAsignadoId == null) {
			if (other.usuarioAsignadoId != null)
				return false;
		} else if (!usuarioAsignadoId.equals(other.usuarioAsignadoId))
			return false;
		if (usuarioCreador == null) {
			if (other.usuarioCreador != null)
				return false;
		} else if (!usuarioCreador.equals(other.usuarioCreador))
			return false;
		if (usuarioCreadorId == null) {
			if (other.usuarioCreadorId != null)
				return false;
		} else if (!usuarioCreadorId.equals(other.usuarioCreadorId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Incidencia [id=").append(id).append(", fecha=").append(fecha).append(", usuarioCreador=")
				.append(usuarioCreador).append(", titulo=").append(titulo).append(", descripcion=").append(descripcion)
				.append(", usuarioAsignado=").append(usuarioAsignado).append(", usuarioCreadorId=")
				.append(usuarioCreadorId).append(", usuarioAsignadoId=").append(usuarioAsignadoId).append("]");
		return builder.toString();
	}
}
