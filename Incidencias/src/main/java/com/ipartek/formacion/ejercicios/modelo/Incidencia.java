package com.ipartek.formacion.ejercicios.modelo;

import java.util.Date;

public class Incidencia {

		private Long id;
		private Date fecha;
		private  String titulo;
		private String descripcion;
		private Long usu_asignado;
		
		public Incidencia() {
			
		}
		public Incidencia(Long id, Date fecha, String titulo, String descripcion, Long usu_asignado) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.usu_asignado = usu_asignado;
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
		public Long getUsu_asignado() {
			return usu_asignado;
		}
		public void setUsu_asignado(Long usu_asignado) {
			this.usu_asignado = usu_asignado;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
			result = prime * result + ((usu_asignado == null) ? 0 : usu_asignado.hashCode());
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
			if (usu_asignado == null) {
				if (other.usu_asignado != null)
					return false;
			} else if (!usu_asignado.equals(other.usu_asignado))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Incidencia [id=" + id + ", fecha=" + fecha + ", titulo=" + titulo + ", descripcion=" + descripcion
					+ ", usu_asignado=" + usu_asignado + "]";
		}

		
		
		
}
