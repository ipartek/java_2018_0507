package com.ipartek.formacion.incidencias.modelos;

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

}
