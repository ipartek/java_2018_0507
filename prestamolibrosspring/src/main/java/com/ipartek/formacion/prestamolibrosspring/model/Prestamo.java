package com.ipartek.formacion.prestamolibrosspring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Prestamo {
	
	@NotNull
	Integer  id;
	@NotNull
    @Size(min=2, max=30)
	String titulo;
	String usuario;

	Date fechaprestamo;

	Date fechdevol;
	
	
	public Prestamo(@NotNull Integer id, @NotNull @Size(min = 2, max = 30) String titulo, String usuario,
			@NotNull @Size(min = 10, max = 10) Date fechaprestamo, @NotNull @Size(min = 10, max = 10) Date fechdevol) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.usuario = usuario;
		this.fechaprestamo = fechaprestamo;
		this.fechdevol = fechdevol;
	}
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", titulo=" + titulo + ", usuario=" + usuario + ", fechaprestamo=" + fechaprestamo
				+ ", fechdevol=" + fechdevol + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaprestamo == null) ? 0 : fechaprestamo.hashCode());
		result = prime * result + ((fechdevol == null) ? 0 : fechdevol.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (fechaprestamo == null) {
			if (other.fechaprestamo != null)
				return false;
		} else if (!fechaprestamo.equals(other.fechaprestamo))
			return false;
		if (fechdevol == null) {
			if (other.fechdevol != null)
				return false;
		} else if (!fechdevol.equals(other.fechdevol))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaprestamo() {
		return fechaprestamo;
	}
	public void setFechaprestamo(Date fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}
	public Date getFechdevol() {
		return fechdevol;
	}
	public void setFechdevol(Date fechdevol) {
		this.fechdevol = fechdevol;
	}

}
