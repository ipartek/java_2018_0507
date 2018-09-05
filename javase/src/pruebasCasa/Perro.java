package pruebasCasa;

import java.util.ArrayList;

public class Perro {
	
	private String nombre;
	public int edad;
	private ArrayList<String> sonidos = new ArrayList<String>();
	
	// Constructores
	
	// Indican las propiedades que tienen en el momento de crearlos
	// Por defecto
	public Perro() {		
		this.nombre = "Otto";
		this.edad = 4;
		this.sonidos.add("Guau guau");
		this.sonidos.add("Grrrr");
		this.sonidos.add("Zaunk");
	}
	
	// Constructor perro concreto
	public Perro(String nombreP, int edadP) {
		super();
		this.nombre = nombreP;
		this.edad = edadP;
		this.sonidos.add("Guau guau");
		this.sonidos.add("Grrrr");
		this.sonidos.add("Zaunk");
	}
	
	public String ladrido(int posicion) {
		
		return sonidos.get(posicion);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNombreMay() {
		return this.nombre.toUpperCase();
	}
		
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", sonidos=" + sonidos + "]";
	}
	
	
	
	
	
	
	
	// al llamar al metodo ladrar, devuelve el sonido enla posicion del array que se indique
	
	
	
}
