package com.ipartek.formacion.otrosEjemplos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejemplo3 {
	
	
	public static void main(String[] args) {
		Map<Punto,String> ubicaciones =new HashMap<>();
		
		ubicaciones.put(new Punto(5,6),"Bilbao");
		ubicaciones.put(new Punto(),"Santutxu");
		ubicaciones.put(new Punto(6,6),"Portu");
		ubicaciones.put(new Punto(6,6),"Barcelona"); //Sobreeescribe el anterior 6.6
		
		
		//Salen en el orden inverso al que se han guardado
		for (Punto ubicacion:ubicaciones.keySet())
			System.out.printf("%s,%s\n",ubicacion,ubicaciones.get(ubicacion));
		
		
		System.out.println("Elemento ubicado en 6,6 es"+ubicaciones.get(new Punto(6,6)));
		
		
	}
	
	
	public static void main1(String[] args) {
		
		Set<Punto> puntos=new HashSet<>(); 
		
		Punto pt = new Punto(3);
		
		puntos.add(new Punto());
		puntos.add(pt);
		puntos.add(new Punto(4,6));
		puntos.add(new Punto(Punto.DEFAULT_X,Punto.DEFAULT_Y));
		puntos.add(new Punto(4,6));								//El hashset no guarda duplicados
		
		
		for(Punto p:puntos)
			System.out.println(p);
		
		System.out.println("FIN");
	}
}
