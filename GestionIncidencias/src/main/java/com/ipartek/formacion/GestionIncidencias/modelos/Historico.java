package com.ipartek.formacion.GestionIncidencias.modelos;

import java.util.Date;

public class Historico {

	private Long id;
	private Incidencia incidencia;
	private Usuario usuario;
	private Date fecha;
	private String comentario;
	private String estado;
	
	private Long usuarioId;
	
	public Historico() {
		// TODO Auto-generated constructor stub
	}

	public Historico(Long id, Incidencia incidencia, Usuario usuario, Date fecha, String comentario, String estado) {
		super();
		this.id = id;
		this.incidencia = incidencia;
		this.usuario = usuario;
		this.fecha = fecha;
		this.comentario = comentario;
		this.estado = estado;
	}
	
	public Historico (Long id, Incidencia incidencia, Long usuarioId, Date fecha, String comentario, String estado) {
		super();
		this.id = id;
		this.incidencia = incidencia;
		this.usuarioId = usuarioId;
		this.fecha = fecha;
		this.comentario = comentario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incidencia == null) ? 0 : incidencia.hashCode());
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
		Historico other = (Historico) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
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
		if (incidencia == null) {
			if (other.incidencia != null)
				return false;
		} else if (!incidencia.equals(other.incidencia))
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
		StringBuilder builder = new StringBuilder();
		builder.append("Historico [id=").append(id).append(", incidencia=").append(incidencia).append(", usuario=")
				.append(usuario).append(", fecha=").append(fecha).append(", comentario=").append(comentario)
				.append(", estado=").append(estado).append("]");
		return builder.toString();
	}
}
