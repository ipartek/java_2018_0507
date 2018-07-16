package com.ipartek.formacion.ejemplo1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;



public class Poligono {
private Punto origen;
private LinkedHashMap<Integer,Punto> puntos=new LinkedHashMap<>();
	public Poligono (Punto origen){
		this.origen=origen;
	}
	public void add(Punto p){
		if(p==null)
			throw new RuntimeException("nooo");
		puntos.put(puntos.size(),p);
	}
	@Override
	public String toString() {
		return "Poligono [origen=" + origen + ", puntos=" + puntos + "]";
	}
	
	public Punto get(int indice) {
	return puntos.get(indice);
		
	}
}
