package com.ipartek.formacion.otrosEjemplos;
import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;

 

public class EjemploLista {

	public static void main(String[] args) {
		List <Punto> puntos = new ArrayList<Punto>();
		
		puntos.add(new Punto());
		puntos.add(new Punto(3));
		puntos.add(new Punto(4,6));
		
		
		for (Punto p:puntos)
			System.out.println(p);
		
		
		System.out.println();
		
		
		Punto pt2=puntos.get(2);
		System.out.println(pt2);
		
		//Punto pt3=new Punto(3);
		//System.out.println(pt3);
		puntos.remove(pt2);
		
		
		
		//Quiero borrar para todo punto p que cumpla...//Solo a partir de JAVA8
		//puntos.removeIf(p -> p.getX() < 2);
		
		
		
		 puntos.removeIf(new Predicate<Punto>(){
		 @Override
		 public boolean test(Punto p){ //test es un metodo
		 	return p.getX() < 2;
		 }
		 });
		
		for (Punto p:puntos)
			System.out.println(p);
		
		
		System.out.println(pt2);

	}

}
