package com.ipartek.formacion.ejemplo1;

public class PuntoNombre extends Punto{
	private String nombre;
	public PuntoNombre(int x, int y, String nombre) {
		super(x,y);
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "PuntoNombre [nombre=" + nombre + super.toString() + "]";
	}
}
