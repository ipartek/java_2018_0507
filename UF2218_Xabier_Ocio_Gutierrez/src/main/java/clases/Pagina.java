package clases;

public class Pagina {
	String texto;
	String Autor;
	public Pagina() {
		
	}
	public Pagina(String texto, String autor) {
		super();
		this.texto = texto;
		Autor = autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
}
