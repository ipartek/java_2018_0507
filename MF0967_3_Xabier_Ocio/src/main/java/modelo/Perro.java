package modelo;

public class Perro {
	String nombre;
	int edad;
	String raza="milrazas";
	int peso;
	Chip pojoChip;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Chip getPojoChip() {
		return pojoChip;
	}
	public void setPojoChip(Chip pojoChip) {
		this.pojoChip = pojoChip;
	}
	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}
	//to string modificado para que muestre datos de chip
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + this.pojoChip.toString()+"]";
	}
	
	
}
