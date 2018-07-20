package com.ipartek.formacion.uf2216;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	private static Scanner s = new Scanner(System.in);
	
	
	public static String leerLinea() {
		String linea;
		boolean hayQueMostrarMensaje = false;
		
		do {
			if(hayQueMostrarMensaje) {
				System.out.println("No cuela con texto en blanco");
			}
			
			linea = s.nextLine().trim();
			
			hayQueMostrarMensaje = true;
		} while( linea.length() == 0 );
		
		return linea;
	}

	public static long leerLong() {
		long l = 0;
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				l = s.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				s.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (hayQueRepetir);
		
		s.nextLine();
		
		return l;
	}

	public static Integer leerInteger() {
		Integer i = 0;
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				i = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				s.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (hayQueRepetir);
		
		s.nextLine();
		
		return i;
	}
	
	
	
}