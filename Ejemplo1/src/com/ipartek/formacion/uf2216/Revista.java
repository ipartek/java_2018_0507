package com.ipartek.formacion.uf2216;

public class Revista {
	
	//Creacion de variables estaticas para controlar los errores de formato con sus respectivos mensajes.
	public static final int TITULO_TAMANO_MIN = 3;
	public static final int TITULO_TAMANO_MAX = 150;
	public static final int ISBN_TAMANO = 10;
	public static final int NUMPAG_TAMANO_MIN = 1;
	
	public static final String TITULO_MENSAJE_EXCEPTION = "El título debe tener entre " + TITULO_TAMANO_MIN + 
			" y " + TITULO_TAMANO_MAX + " caracteres";
	public static final String ISBN_MENSAJE_EXCEPTION = "El ISBN debe tener " + ISBN_TAMANO + " caracteres";
	public static final String NUMPAG_MENSAJE_EXCEPTION = "La revista debe tener como mínimo " + NUMPAG_TAMANO_MIN + " pagina";
	
	//TODO: controlar formatos correctos
	private long id;
	private String titulo;
	private String isbn;
	private long numPag;
	private boolean formato;

	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.numPag = 0;
		this.formato = false;
	}
	
	public Revista(long id, String titulo, String isbn, long numPag, boolean formato) throws Exception {
		super();	
		this.setId(id);
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setNumPag(numPag);
		this.setFormato(formato);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	//Controlamos la excepcion de titulo
	public void setTitulo(String titulo) throws Exception {
		if(titulo != null && titulo.trim().length() >= TITULO_TAMANO_MIN 
				&& titulo.trim().length() <= TITULO_TAMANO_MAX) {
			
			this.titulo = titulo;
			
		}else {
			throw new Exception(TITULO_MENSAJE_EXCEPTION);
		}
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	//Controlamos la excepcion del isbn
	public void setIsbn(String isbn) throws Exception {
		if(isbn != null && isbn.trim().length() == ISBN_TAMANO) {
			this.isbn = isbn;
			
		}else {
			throw new Exception(ISBN_MENSAJE_EXCEPTION);
		}
	}
	
	public long getNumPag() {
		return numPag;
	}
	
	
	//Controlamos la excepcion del numero de paginas
	public void setNumPag(long numPag) throws Exception {
		if(numPag >= NUMPAG_TAMANO_MIN) {
			this.numPag = numPag;
			
		}else {
			throw new Exception(NUMPAG_MENSAJE_EXCEPTION);
		}
	}
	
	public boolean isFormato() {
		return formato;
	}
	
	public void setFormato(boolean formato) {
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numPag=" + numPag + ", formato=" + formato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + (int) (numPag ^ (numPag >>> 32));
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
		Revista other = (Revista) obj;
		if (formato != other.formato)
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numPag != other.numPag)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	

}