package com.ipartek.formacion.springrestcrud.entidades;

public class Incidencia {

	
	private Long id;

	private String fecha, usuario_creador,titulo,descripcion,equipo,usuario_asignado,estado;
	
	public Incidencia() {}
	
	public Incidencia(Long id, String fecha, String usuario_creador, String titulo, String descripcion, String equipo,
			String usuario_asignado, String estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario_creador = usuario_creador;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.equipo = equipo;
		this.usuario_asignado = usuario_asignado;
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUsuario_creador() {
		return usuario_creador;
	}

	public void setUsuario_creador(String usuario_creador) {
		this.usuario_creador = usuario_creador;
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

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getUsuario_asignado() {
		return usuario_asignado;
	}

	public void setUsuario_asignado(String usuario_asignado) {
		this.usuario_asignado = usuario_asignado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario_asignado == null) ? 0 : usuario_asignado.hashCode());
		result = prime * result + ((usuario_creador == null) ? 0 : usuario_creador.hashCode());
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
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
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
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario_asignado == null) {
			if (other.usuario_asignado != null)
				return false;
		} else if (!usuario_asignado.equals(other.usuario_asignado))
			return false;
		if (usuario_creador == null) {
			if (other.usuario_creador != null)
				return false;
		} else if (!usuario_creador.equals(other.usuario_creador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", fecha=" + fecha + ", usuario_creador=" + usuario_creador + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", equipo=" + equipo + ", usuario_asignado="
				+ usuario_asignado + ", estado=" + estado + "]";
	}

	


}