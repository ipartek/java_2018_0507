package com.ipartek.formacion.ejemplo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.LocalDate;

public class Prueba1 {

	public final static int TAM_ARRAY = 10;

	public static void main(String[] args) {
		PuntoNombre ptn = new PuntoNombre(1,2,"Prueba");
		System.out.println(ptn);
	}
	public static void mainRecursividad(String[] args) {
		System.out.println(factorial(5));
	}
	
	public static int factorial(int valor) {
		if(valor > 1) {
			return valor * factorial(valor - 1);
		} else {
			return 1;
		}
	}
	
	public static void mainPoligono(String[] args) {
		Punto origen = new Punto(0,0);
		Poligono poligono = new Poligono(origen);
		
		poligono.add(new Punto(1,2));
		poligono.add(new Punto(3,4));

		poligono.get(0).setX(10);
		
		poligono.getOrigen().setY(200);
		
		System.out.println(poligono);
		System.out.println(poligono.get(1));
		

	}
	
	public static void mainIncrementos(String[] args) {
		int i = 1;

//		x = x @ y;
//		x @= y;
//		i = i + 1;
//		i += 1;
//		i++;
//		++i;

		System.out.println(i);		//1
		System.out.println(i++);	//1
		System.out.println(i);		//2
		System.out.println(++i);	//3
		System.out.println(i);		//3
		System.out.println(i--);	//3
		System.out.println(i);		//2
		System.out.println(--i);	//1
		System.out.println(i);		//1
	}

	public static void mainTime(String[] args) {
		ejemploJodaTime();

		ejemploJava8JavaTime();
	}

	private static void ejemploJava8JavaTime() {
		// Java 8
		java.time.LocalDate j8newYear = java.time.LocalDate.now().plusYears(1).withDayOfYear(1);
		System.out.println(j8newYear);
	}

	private static void ejemploJodaTime() {
		// joda-time (Java 5 -> Java 7) Referencia externa en jar
		LocalDate newYear = LocalDate.now().plusYears(1).withDayOfYear(1);
		System.out.println(newYear);
	}

	public static void mainMap(String[] args) {
		Map<Punto, String> ubicaciones = new HashMap<>();

		ubicaciones.put(new Punto(5, 6), "Bilbao");
		ubicaciones.put(new Punto(), "Santutxu");
		ubicaciones.put(new Punto(6, 6), "Bilbao");
		ubicaciones.put(new Punto(6, 6), "Barcelona");

		for (Punto ubicacion : ubicaciones.keySet()) {
			System.out.printf("%s, %s\n", ubicacion, ubicaciones.get(ubicacion));
		}

		System.out.println(ubicaciones.get(new Punto(6, 6)));
	}

	public static void mainSet(String[] args) {
		Set<Punto> puntos = new HashSet<>();

		Punto pt = new Punto(3);

		puntos.add(new Punto());
		puntos.add(pt);
		puntos.add(new Punto(3, 3));
		puntos.add(new Punto(4, 6));

		for (Punto p : puntos)
			System.out.println(p);
	}

	public static void mainListas(String[] args) {
		List<Punto> puntos = new ArrayList<>();// <Punto>();

		Punto pt = new Punto(3);

		puntos.add(new Punto());// new java.util.Date());
		puntos.add(pt);
		puntos.add(new Punto(4, 6));

		Punto ptBorrar = new Punto(3);

		puntos.remove(ptBorrar);

		puntos.removeIf(p -> p.getX() < 2); // Java8

		// puntos.removeIf(new Predicate<Punto>() {
		// @Override
		// public boolean test(Punto p) {
		// return p.getX() < 2;
		// }
		// });

		for (Punto p : puntos)
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
		v.add(new Punto(1, 2));
		Object o = (Object) new Punto(3, 4);
		v.add(o);

		for (int i = 0; i < v.size(); i++)
			System.out.println(v.elementAt(i));

		Punto p = (Punto) v.elementAt(2);
		System.out.println(p.getY());
	}

	public static void mainLogger(String[] args) {
		System.out.println("Hola a todos");

		Logger l = Logger.getLogger(Prueba1.class.getName()); // getClass().getName());
		l.info("Prueba de logger");
		l.log(Level.SEVERE, "Prueba GRAVE", new RuntimeException("Prueba de excepción"));

		String sNum = "123";
		int i = Integer.parseInt(sNum);

		i = Integer.MAX_VALUE;

		i++;

		System.out.println(i);
	}

	public static void mainArrayBidimensional(String[] args) {
		char[][] tablero = new char[8][8];

		tablero[0] = new char[] { 'T', 'C', 'A', 'R', 'r', 'A', 'C', 'T' };
		tablero[7] = tablero[0].clone();

		for (int fila = 1; fila <= 6; fila += 5) {
			for (int columna = 0; columna < 8; columna++) {
				tablero[fila][columna] = 'p';
			}
		}

		tablero[0][3] = ' ';

		for (int fila = 0; fila < 8; fila++) {
			for (int columna = 0; columna < 8; columna++) {
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

		int[] arr2 = { 5, 2 };

		System.out.println(arr2[0]);

		String[] diasSemana = new String[] { "Lunes", "Martes" };

		System.out.println(diasSemana[1].toLowerCase());

		Punto[] puntosPorDefecto = { new Punto(1), new Punto(2) };

		System.out.println(puntosPorDefecto[1].toString().toUpperCase());

		Punto[] puntos = new Punto[TAM_ARRAY];

		puntos[0] = new Punto(123, 2);

		for (int i = 0; i < puntos.length; i++) {
			puntos[i] = new Punto(i);
		}

		for (Punto p : puntos) {
			System.out.println(p);
		}

		Punto p;
		for (int i = 0; i < puntos.length; i++) {
			p = puntos[i];
			System.out.println(p);
		}

		for (int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i]);
		}
	}

	public static void mainPunto(String[] args) {
		System.out.println("BIENVENIDOS A GIT");

		Punto p = new Punto(3, 4);

		Punto pt2 = (Punto) p.clone();

		p.setX(100);

		System.out.println(p.equals(pt2));

		System.out.println(p); // .hashCode());
		System.out.println(pt2); // .hashCode());

		Object o = p;

		// System.out.println(o.getX());

		Punto pt1 = (Punto) o;

		System.out.println(pt1);

		int i = 5;

		Object o2 = i;// new Integer(i);
		System.out.println(o2);
		System.out.println("Fin");
	}

}
