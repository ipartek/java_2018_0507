package com.ipartek.formacion.ejemplo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.LocalDate;

public class Prueba1 {

	private static final String RUTA_FICHERO = "C:\\trabajos\\fichero.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean SOBREESCRIBIR = false;
	public final static int TAM_ARRAY = 10;

<<<<<<< HEAD

	public enum Genero {
		MUJER, HOMBRE
	};

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
		PrintWriter pw = new PrintWriter(fw,AUTO_FLUSH);

		pw.println("Hola desde Java");
		pw.println("Segunda línea");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(RUTA_FICHERO);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		while( (linea = br.readLine()) != null ) {
			System.out.println(linea);
		}
		
		br.close();
		fr.close();
	}
	

	public static void mainSwitchPeculiar(String[] args) {
		int mes, dias;

		mes = 6;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.printf("El mes %d tiene %d días", mes, dias);
	}


	public static void mainRegEx(String[] args) {
		System.out.println("C:\\nuevos\\trabajos");

		String regex = "\\w+@\\w+\\.\\w+";

		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("formacionipartek.com");
		System.out.println(matcher.matches());

		System.out.println("formacion@ipartek.com".matches(regex));
	}

	public static void mainInterfaces(String[] args) {
		Number nEjemplo = new Float(3.4);
		System.out.println(nEjemplo);

		Number[] numeros = new Number[2];

		numeros[0] = new Integer(5);
		numeros[1] = new Double(6.7);

		for (Number n : numeros) {
			System.out.println(n.doubleValue());
		}
	}

	// A partir de JavaSE7 existe esto:
	// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
	@SuppressWarnings("null")
	public static void mainExcepciones(String[] args) {
		int div = 0, a, b;
		a = 5;
		b = 0;

		try {
			Punto p;
			try {
				p = new Punto(500000000, 2);
			} catch (PuntoException e) {
				System.out.println(e.getMessage());
				p = new Punto(Punto.MAX_X, Punto.MAX_Y);
			}

			System.out.println(p);

			String s = null;

			System.out.println(s.toUpperCase());

			int[] arr = new int[2];
			arr[2] = 5;

			// b = 1;
			div = a / b;
		} catch (ArithmeticException ae) {
			System.out.println("División por cero");
			div = Integer.MAX_VALUE;
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println(aioobe.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("ME EJECUTO POR MIS NARICES");
		}

		System.out.println(div);

		System.out.println("FIN");
	}

	public static void mainCalendar(String[] args) {
		Calendar c = Calendar.getInstance();

		System.out.println(c.getTime());

		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));

	}

	public static void mainPuntoNombre(String[] args) {
		PuntoNombre ptn = new PuntoNombre(1, 2, "Prueba");
		System.out.println(ptn);
	}

	public static void mainRecursividad(String[] args) {
		System.out.println(factorial(5));
	}

	public static int factorial(int valor) {
		if (valor > 1) {
			return valor * factorial(valor - 1);
		} else {
			return 1;
		}
	}

	public static void mainPoligono(String[] args) {
		Punto origen = new Punto(0, 0);
		Poligono poligono = new Poligono(origen);

		poligono.add(new Punto(1, 2));
		poligono.add(new Punto(3, 4));

		poligono.get(0).setX(10);

		poligono.getOrigen().setY(200);

		System.out.println(poligono);
		System.out.println(poligono.get(1));

	}

	public static void mainIncrementos(String[] args) {
		int i = 1;

		// x = x @ y;
		// x @= y;
		// i = i + 1;
		// i += 1;
		// i++;
		// ++i;

		System.out.println(i); // 1
		System.out.println(i++); // 1
		System.out.println(i); // 2
		System.out.println(++i); // 3
		System.out.println(i); // 3
		System.out.println(i--); // 3
		System.out.println(i); // 2
		System.out.println(--i); // 1
		System.out.println(i); // 1
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
=======
	public enum Genero {
		MUJER, HOMBRE
	};

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
		PrintWriter pw = new PrintWriter(fw,AUTO_FLUSH);
		
		pw.println("Hola desde Java");
		pw.println("Segunda línea");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(RUTA_FICHERO);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		while( (linea = br.readLine()) != null ) {
			System.out.println(linea);
		}
		
		br.close();
		fr.close();
	}
	
	public static void mainSwitchPeculiar(String[] args) {
		int mes, dias;

		mes = 6;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.printf("El mes %d tiene %d días", mes, dias);
	}

	public static void mainEnum(String[] args) {
		Genero miGenero;

		miGenero = Genero.HOMBRE;

		System.out.println(miGenero);
	}

	public static void mainRegEx(String[] args) {
		System.out.println("C:\\nuevos\\trabajos");

		String regex = "\\w+@\\w+\\.\\w+";

		System.out.println(regex);

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("formacionipartek.com");
		System.out.println(matcher.matches());

		System.out.println("formacion@ipartek.com".matches(regex));
	}

	public static void mainInterfaces(String[] args) {
		Number nEjemplo = new Float(3.4);
		System.out.println(nEjemplo);

		Number[] numeros = new Number[2];

		numeros[0] = new Integer(5);
		numeros[1] = new Double(6.7);

		for (Number n : numeros) {
			System.out.println(n.doubleValue());
		}
	}

	// A partir de JavaSE7 existe esto:
	// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
	@SuppressWarnings("null")
	public static void mainExcepciones(String[] args) {
		int div = 0, a, b;
		a = 5;
		b = 0;

		try {
			Punto p;
			try {
				p = new Punto(500000000, 2);
			} catch (PuntoException e) {
				System.out.println(e.getMessage());
				p = new Punto(Punto.MAX_X, Punto.MAX_Y);
			}

			System.out.println(p);

			String s = null;

			System.out.println(s.toUpperCase());

			int[] arr = new int[2];
			arr[2] = 5;

			// b = 1;
			div = a / b;
		} catch (ArithmeticException ae) {
			System.out.println("División por cero");
			div = Integer.MAX_VALUE;
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println(aioobe.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("ME EJECUTO POR MIS NARICES");
		}

		System.out.println(div);

		System.out.println("FIN");
	}

	public static void mainCalendar(String[] args) {
		Calendar c = Calendar.getInstance();

		System.out.println(c.getTime());

		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));

	}

	public static void mainPuntoNombre(String[] args) {
		PuntoNombre ptn = new PuntoNombre(1, 2, "Prueba");
		System.out.println(ptn);
	}

	public static void mainRecursividad(String[] args) {
		System.out.println(factorial(5));
	}

	public static int factorial(int valor) {
		if (valor > 1) {
			return valor * factorial(valor - 1);
		} else {
			return 1;
		}
	}

	public static void mainPoligono(String[] args) {
		Punto origen = new Punto(0, 0);
		Poligono poligono = new Poligono(origen);

		poligono.add(new Punto(1, 2));
		poligono.add(new Punto(3, 4));

		poligono.get(0).setX(10);

		poligono.getOrigen().setY(200);

		System.out.println(poligono);
		System.out.println(poligono.get(1));

	}

	public static void mainIncrementos(String[] args) {
		int i = 1;

		// x = x @ y;
		// x @= y;
		// i = i + 1;
		// i += 1;
		// i++;
		// ++i;

		System.out.println(i); // 1
		System.out.println(i++); // 1
		System.out.println(i); // 2
		System.out.println(++i); // 3
		System.out.println(i); // 3
		System.out.println(i--); // 3
		System.out.println(i); // 2
		System.out.println(--i); // 1
		System.out.println(i); // 1
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
>>>>>>> branch 'Javier_Lete' of https://github.com/ipartek/java_2018_0507.git
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
