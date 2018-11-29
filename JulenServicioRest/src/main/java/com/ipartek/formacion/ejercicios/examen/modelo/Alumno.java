package com.ipartek.formacion.ejercicios.examen.modelo;

public class Alumno {
		
		private Long id;
		private String nombre;
		private String apellidos;

		
		
		public Alumno(String nombre, String apellidos) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
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
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
			Alumno other = (Alumno) obj;
			if (apellidos == null) {
				if (other.apellidos != null)
					return false;
			} else if (!apellidos.equals(other.apellidos))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
		}
		
		
}
