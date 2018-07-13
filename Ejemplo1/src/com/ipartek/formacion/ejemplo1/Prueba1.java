package com.ipartek.formacion.ejemplo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba1 {

	public final static int TAM_ARRAY = 10;
	
	public static void main(String[] args) {


		List<Punto> puntos = new ArrayList<>();//<Punto>();
		
		Punto pt = new Punto(3);
		
		puntos.add(new Punto());//new java.util.Date());
		puntos.add(pt);
		puntos.add(new Punto(4,6));
		
		Punto ptBorrar = new Punto(3);
		
		puntos.remove(ptBorrar);
		
		puntos.removeIf( p -> p.getX() < 2 ); //Java8
		
//		puntos.removeIf(new Predicate<Punto>() {
//			@Override
//			public boolean test(Punto p) {
//				return p.getX() < 2;
//			}
//		});
		
		for(Punto p: puntos)
			System.out.println(p);
		
		Punto pt2 = puntos.get(1);
		System.out.println(pt2);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void mainVector(String[] args) {
		Vector v = new Vector();
		
		v.add(new Integer(1));
		v.add("Hola");
		v.add(new java.util.Date());
		v.add(new Punto(1,2));
		Object o = (Object)new Punto(3,4);
		v.add(o);
		
		for(int i = 0; i < v.size(); i++)
			System.out.println(v.elementAt(i));
		
		Punto p = (Punto) v.elementAt(2);
		System.out.println(p.getY());
	}
	
	public static void mainLogger(String[] args) {
		System.out.println("Hola a todos");
		
		Logger l = Logger.getLogger(Prueba1.class.getName()); //getClass().getName());
		l.info("Prueba de logger");
		l.log(Level.SEVERE, "Prueba GRAVE", 
				new RuntimeException("Prueba de excepción"));
		
		String sNum = "123";
		int i = Integer.parseInt(sNum);
		
		i = Integer.MAX_VALUE;
		
		i++;
		
		System.out.println(i);


	}
	
	public static void mainArrayBidimensional(String[] args) {
		char[][] tablero= new char[8][8];
		
		tablero[0] = new char[] {'T', 'C', 'A', 'R', 'r', 'A', 'C', 'T'};
		tablero[7] = tablero[0].clone();
		
		for(int fila = 1; fila <= 6; fila += 5) {
			for(int columna = 0; columna < 8; columna++) {
				tablero[fila][columna] = 'p';
			}
		}
		
		tablero[0][3] = ' ';
		
		for(int fila = 0; fila < 8; fila++) {
			for(int columna = 0; columna < 8; columna++) {
				System.out.print(tablero[fila][columna]);
			}
			System.out.println();
		}
	}
	
	public static void mainArrays(String[] args) {
		System.out.println(Math.sqrt(4));
		
		int[] arr = new int[2];
		
		arr[0] = 5;
		arr[1] = 2;
		
		int[] arr2 = {5,2};
		
		System.out.println(arr2[0]);
		
		String[] diasSemana = new String[] { "Lunes", "Martes" };
		
		System.out.println(diasSemana[1].toLowerCase());
				
		Punto[] puntosPorDefecto = { new Punto(1), new Punto(2) };
		
		System.out.println(puntosPorDefecto[1].toString().toUpperCase());

		Punto[] puntos = new Punto[TAM_ARRAY];
		
		puntos[0] = new Punto(123,2);

		for(int i = 0; i < puntos.length; i++) {
			puntos[i] = new Punto(i);
		}
		
		for(Punto p: puntos) {
			System.out.println(p);
		}
		
		Punto p;
		for(int i = 0; i < puntos.length; i++) {
			p = puntos[i];
			System.out.println(p);
		}
		
		for(int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i]);
		}
	}
	
	public static void mainPunto(String[] args) {
		System.out.println("BIENVENIDOS A GIT");
		
		Punto p = new Punto(3,4);
		
		Punto pt2 = (Punto) p.clone();
		
		p.setX(100);
		
		System.out.println(p.equals(pt2));
		
		System.out.println(p); //.hashCode());
		System.out.println(pt2); //.hashCode());
		
		Object o = p;
		
		//System.out.println(o.getX());
		
		Punto pt1 = (Punto) o;
		
		System.out.println(pt1);
		
		int i = 5;
		
		Object o2 = i;//new Integer(i);
		System.out.println(o2);
		System.out.println("Fin");
	}

}










