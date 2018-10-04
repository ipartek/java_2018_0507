package com.ipartek.formacion.uf2216;

public class Revistas {
	private long id;
	private String titulo;
	private String ISBN;
	private int num_paginas;
	private boolean formato;
	
	
	public Revistas(long id, String titulo, String ISBN, int num_paginas, boolean formato) {
		this.id = id;
		this.titulo = titulo;
		this.ISBN = ISBN;
		this.num_paginas = num_paginas;
		this.formato = formato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public int getNumPaginas() {
		return num_paginas;
	}

	public void setNumPaginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}
	
	public boolean getFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Revistas [id=" + id + ", titulo=" + titulo + ", ISBN=" + ISBN + ", num_paginas=" + num_paginas
				+ ", formato=" + formato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + num_paginas;
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
		if (num_paginas != other.num_paginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}

