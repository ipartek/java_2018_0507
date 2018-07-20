package com.ipartek.formacion.uf2216.pojo;

/*
 * 1.Titulo tamaño mínimo 3 letras, máximo 150
 * 2.ISBN número de longitud 10
 * 3.Número de Páginas mínimo 1
 * 4.Formato ( digital o papel )  true == digital false == papel
*/
public class Revista {
	
	private static final int TAMANO_MIN_TITULO = 3;
	private static final int TAMANO_MAX_TITULO = 150;
	private static final String TAMANO_TITULO_EXCEPTION = "El longitud del titulo tiene que ser entre " + TAMANO_MIN_TITULO + " y " + TAMANO_MAX_TITULO;
	
	private static final int TAMANO_ISBN = 10;
	private static final String TAMANO_ISBN_EXCEPTION = "La longitud del ISBN debe ser " + TAMANO_ISBN;
	
	private static final int PAGINAS_MIN = 1;
	private static final String PAGINAS_MIN_EXCEPTION = "El numero minimo de paginas debe ser: " + PAGINAS_MIN;
	
	private int id;
	private String titulo;
	private String isbn;
	private int paginas;
	private boolean formato;
	
	public Revista() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.paginas = 0;
		this.formato = false;
	}
	
	public Revista(int id, String titulo, String isbn, int paginas, boolean formato) throws Exception {
		setId(id);
		setTitulo(titulo);
		setIsbn(isbn);
		setPaginas(paginas);
		setFormato(formato);
	}
	
	@Override
	public String toString() {
		return "Revistas [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato="
				+ formato + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Guardamos el valor del titulo
	 * @param titulo String titulo del Libro
	 * @throws Exception si titulo.length < TAMANO_MIN_TITULO && titulo.length != TAMANO_MAX_TITULO
	 */
	public void setTitulo(String titulo) throws Exception{
		if (titulo.length() > TAMANO_MIN_TITULO && titulo.length() < TAMANO_MAX_TITULO) {
			this.titulo = titulo;
		}else {
			throw new Exception(TAMANO_TITULO_EXCEPTION);
		}
	}
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Guardamos el valor del ISBN
	 * @param isbn String identificador del Libro
	 * @throws Exception si ISBN == null || ISBN.length != TAMANO_ISBN
	 */
	public void setIsbn(String isbn) throws Exception {
		if ( isbn != null && isbn.trim().length() == TAMANO_ISBN) {
			this.isbn = isbn;	
		}else {
			throw new Exception(TAMANO_ISBN_EXCEPTION);
		}	
	}
	
	public int getPaginas() {
		return paginas;
	}
	/**
	 * Guardamos el valor de paginas
	 * @param paginas int paginas del Libro
	 * @throws Exception si paginas.length < PAGINAS_MIN
	 */
	public void setPaginas(int paginas) throws Exception{
		if (paginas >= PAGINAS_MIN ) {
			this.paginas = paginas;	
		}else {
			throw new Exception(PAGINAS_MIN_EXCEPTION);
		}	
	}
	public boolean isFormato() {
		return formato;
	}
	/**
	 * Guardamos el valor de formato
	 * @param formato string formato del libro( true: digital, false: papel)
	 * @throws Exception si formato != true && formato != false
	 */
	public void setFormato(boolean formato) throws Exception{
		this.formato = formato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formato ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
