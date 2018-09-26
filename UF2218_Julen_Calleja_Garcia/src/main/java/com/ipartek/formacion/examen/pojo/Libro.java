package com.ipartek.formacion.examen.pojo;

public class Libro implements Identificable {
	
		private long id;
		private String texto;
		
		public Libro(String texto) {
			this(-1, texto);
		}
		
		public Libro(long id, String texto) {
			super();
			this.id = id;
			this.texto = texto;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
			Libro other = (Libro) obj;
			if (id != other.id)
				return false;
			if (texto == null) {
				if (other.texto != null)
					return false;
			} else if (!texto.equals(other.texto))
				return false;
			return true;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
}
