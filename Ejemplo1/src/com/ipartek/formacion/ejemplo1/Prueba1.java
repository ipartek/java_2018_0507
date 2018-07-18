package com.ipartek.formacion.ejemplo1;

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
//import org.joda.time.field.ZeroIsMaxDateTimeField;

//import java.util.function.Predicate;
//https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
public class Prueba1 {

	public final static int TAM_ARRAY = 10;
	public enum Genero{HOMBRE,MUJER}
	public static void main(String[] args) {
//		ejemploJodaTime();
//		javaTime8Ejemplo();
//		creaPoli();
//		puntoNombre();
//		calendario();
		//excepciones();
		expresionesRegulares();
	}
	public static void generoYo() {
		Genero miGenero;
		miGenero=Genero.HOMBRE;
	}
	public static void expresionesRegulares()
	{
		System.out.println("c:\\nuevos\\trabajos");
		String regex="\\w+@\\w+\\.\\w+";
		System.out.println(regex);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("formacion@ipartek.com");
		System.out.println(matcher.matches());
		System.out.println("formacion@ipartek.com".matches(regex));
	}
	public static void excepciones()
	{
		int div = 0,a,b;
		a=5;
		b=0;
		try {
//			String s=null;
//			System.out.println(s.toUpperCase());			
//			int [] array=new int[2];
//			array[2]=5;
			@SuppressWarnings("unused")
			Punto p;
			try {
				 p=new Punto(100000,100000);
				
			} catch (PuntoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				p=new Punto(Punto.MAX_X,Punto.MAX_Y);
			}
			div=a/b;
			System.out.println(div);
		}catch (ArithmeticException e) {
			System.out.println("entre 0");
			div=Integer.MAX_VALUE;
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println(ae.getMessage());
		}
		catch (Exception e) {
		System.out.println("nuse");
		e.printStackTrace();}
		finally {
			System.out.println("me ejcuto por mis narizez");}
		
		System.out.println(div);
	}
	public static void calendario()
	{
		Calendar c=Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));		
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
	}
	public static void puntoNombre()
	{
		PuntoNombre pn=new PuntoNombre(1, 1, "iñaki");
		System.out.println(pn);
	}
	public static void creaPoli()
	{
		Punto miOrigen=new Punto(2,3);
		Punto miOrigen2=new Punto(2,30);
		Poligono poligono=new Poligono(new Punto(0,0));
		poligono.add(miOrigen);
		poligono.add(miOrigen2);
		System.out.println(poligono);
	}
	@SuppressWarnings("unused")
	private static void javaTime8Ejemplo() {
		java.time.LocalDate j8newYear = java.time.LocalDate.now().plusYears(1).withDayOfYear(1);
		System.out.println(j8newYear);
	}

	@SuppressWarnings("unused")
	private static void ejemploJodaTime() {
		LocalDate now;
		LocalDate newYear = LocalDate.now().plusYears(1).withDayOfYear(1);
		System.out.println(newYear);
	}

	public static void mainMap(String[] args) {
		Map<Punto, String> ubicaciones = new HashMap<>();
		ubicaciones.put(new Punto(5, 6), "bilbao");
		ubicaciones.put(new Punto(), "santutxu");
		ubicaciones.put(new Punto(6, 6), "bilbao");
		ubicaciones.put(new Punto(6, 6), "barcelona");
		for (Punto ubicacion : ubicaciones.keySet()) {
			System.out.printf("%s,%s\n", ubicacion, ubicaciones.get(ubicacion));
		}

		System.out.println(ubicaciones.get(new Punto(6, 6)));
	}

	public static void mainHashSet(String[] args) {
		// mainListas(args);
		Set<Punto> puntos = new HashSet<>();
		Punto pt = new Punto(3);

		puntos.add(new Punto());
		puntos.add(pt);
		puntos.add(new Punto(3, 3));
		for (Punto p : puntos)
			System.out.println(p);
	}

	public static void mainListas(String[] args) {
		List<Punto> puntos = new ArrayList<>();// <Punto>();

		Punto pt = new Punto(3);

		puntos.add(new Punto());// new java.util.Date());
		puntos.add(pt);
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
		v.add(1);
		v.add("hola");
		v.add(new java.util.Date());
		v.add(new Punto(11));
		for (int i = 0; i < v.size(); i++)
			System.out.println(v.elementAt(i));
		System.out.println(((Punto) v.elementAt(3)).getX());
	}

	public static void mainLog(String[] args) {
		System.out.println("Hola Javier iñaki");
		Logger l = Logger.getLogger(Prueba1.class.getName());

		l.info("prueba de logger");
		l.info("hola");
		l.log(Level.SEVERE, "casco por todos lados", new RuntimeException("prueba excepcion"));

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
