package com.ipartek.formacion.ejercicios.modelo;

import java.util.Date;

public class Historico {

		
		private Long id;
		
		private Date fecha;
		private String comentario;
		private String estado;
		
		private Usuario user;

		public Historico(Long id, Date fecha, String comentario, String estado, Usuario user) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.comentario = comentario;
			this.estado = estado;
			this.user = user;
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

		public Usuario getUser() {
			return user;
		}

		public void setUser(Usuario user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Historico [id=" + id + ", fecha=" + fecha + ", comentario=" + comentario + ", estado=" + estado
					+ ", user=" + user + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
			result = prime * result + ((estado == null) ? 0 : estado.hashCode());
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
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
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

		
		
}
