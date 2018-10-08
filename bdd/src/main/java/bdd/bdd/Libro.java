package bdd.bdd;

public class Libro {

	private String idLibro;
	private String nombre;
	
	public Libro() {
		
	}
	
	
	public Libro(String idLibro, String nombre) {
		
		this.idLibro = idLibro;
		this.nombre = nombre;
	}
	
	public String getIdLibro() {
		return idLibro;
	}


	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
	
	
	
	
}
