package com.ipartek.formacion.uf2216.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	private static Scanner s = new Scanner(System.in);;

	/* Leer linea con clase Scanner y comprobaciones */
	public static String leerLinea() {
		String linea;
		boolean hayQueMostrarMensaje = true;
		
		do {
			if(hayQueMostrarMensaje) {
				System.out.println("No cuela con texto en blanco");
			}
			
			linea = s.nextLine().trim();
			
			hayQueMostrarMensaje = true;
		} while(linea.length() == 0);

		return linea;
	}
	
	/* Leer Long con clase Scanner y comprobaciones */
	public static long leerLong() {
		long l = 0;
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				l = s.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Por favor introduce un numero entero sin comas ni puntos");
				s.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		}while(hayQueRepetir);
		
		s.nextLine();
		
		return l;
	}
	
	/* Leer Int con clase Scanner y comprobaciones */
	public static int leerInt() {
		int i = 0;
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				i = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor introduce un numero entero sin comas ni puntos");
				s.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		}while(hayQueRepetir);
		
		s.nextLine();
		
		return i;
	}

	
}
