package com.ipartek.formacion.ejemplo1;

public class Prueba1 {

	public final static int TAM_ARRAY = 10;
	//
	
	public static void main(String[] args) {
		System.out.println("Hola Mikel Gil");
		System.out.println("Hola Carlos");
		
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










