package com.ipartek.formacion.uf2216;

public class Revistas {
	
		private long id;
		private String titulo;
		private String ISBN;
		private int paginas;
		private boolean formato;
		
		

		public Revistas(long id, String titulo, String iSBN, int paginas, boolean formato) {
			super();
			this.id = id;
			this.titulo = titulo;
			ISBN = iSBN;
			this.paginas = paginas;
			this.formato = formato;
		}
		


		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getISBN() {
			return ISBN;
		}
		public void setISBN(String iSBN) {
			ISBN = iSBN;
		}
		public int getPaginas() {
			return paginas;
		}
		public void setPaginas(int paginas) {
			this.paginas = paginas;
		}
		public boolean isFormato() {
			return formato;
		}
		public void setFormato(boolean formato) {
			this.formato = formato;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
			result = prime * result + (formato ? 1231 : 1237);
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + paginas;
			result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
			Revistas other = (Revistas) obj;
			if (ISBN == null) {
				if (other.ISBN != null)
					return false;
			} else if (!ISBN.equals(other.ISBN))
				return false;
			if (formato != other.formato)
				return false;
			if (id != other.id)
				return false;
			if (paginas != other.paginas)
				return false;
			if (titulo == null) {
				if (other.titulo != null)
					return false;
			} else if (!titulo.equals(other.titulo))
				return false;
			return true;
		}
		
		
		
}
