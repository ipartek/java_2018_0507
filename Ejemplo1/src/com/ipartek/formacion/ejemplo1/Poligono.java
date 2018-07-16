package com.ipartek.formacion.ejemplo1;

import java.util.LinkedHashSet;

// ni, ny, nn, n, gn

public class Poligono {
	private Punto origen;
	private LinkedHashSet<Punto> puntos = new LinkedHashSet<>();
	
	public Poligono(Punto origen) {
		this.origen = origen;
	}
	
	public void add(Punto punto) {
		if(punto == null)
			throw new RuntimeException("No se admiten puntos nulos");
		
		puntos.add(punto);
	}
	
	public Punto get(int indice) {
		int i = 0;
		for(Punto punto: puntos) {
			if(i++ == indice) {
				return punto;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Poligono [origen=" + origen + ", puntos=" + puntos + "]";
	}
}
