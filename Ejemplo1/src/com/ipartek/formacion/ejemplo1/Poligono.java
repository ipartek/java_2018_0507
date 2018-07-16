package com.ipartek.formacion.ejemplo1;

import java.util.LinkedHashSet;

public class Poligono {

	private Punto origen;
	private LinkedHashSet<Punto> puntos = new LinkedHashSet<>();
	//private LinkedHashMap<Integer> puntos = new LinkedHashMap<>();
	
	public Poligono(Punto origen) {
		super();
		this.origen = origen;
	}

	public void add(Punto punto) {
		if(punto == null)
			throw new RuntimeException();
		puntos.add(punto);
	}
	
	public Punto get(int indice) {
		for (Punto punto:puntos) {
			int i = 0;
			if(i == indice) {
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
