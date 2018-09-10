package com.ipartek.formacion.uf2216rec.presentacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	private static Scanner s = new Scanner(System.in);
	
	public static boolean leerBoolean() {
		String sOperativo;
		boolean android = false;
		
		do {
				System.out.println("¿Uticiza un sistema operativo Android? si/no");
				sOperativo = s.nextLine().trim();
			
		} while( sOperativo.length() == 0 || !sOperativo.equals("si") && !sOperativo.equals("no"));
		
		if (sOperativo.equals("si")) {
			android = true;
		}
		else {
			android = false;
		}
		
		return android;
		}
	
	public static String leerLinea() {
		String linea;

		do {
			System.out.println("Introduce datos:");
						
			linea = s.nextLine().trim();
			
		} while( linea.length() <= 2 || linea.length() >= 16);
		
		return linea;
	}
	
	public static long leerLong() {
		long l = 0;
		boolean repetir;
		
		do {
			try {
				repetir = false;
				l = s.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				s.nextLine();
				repetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (repetir);
		
		s.nextLine();
		
		return l;
	}

	public static int leerInt() {
		int i = 0;
		boolean repetir;
		
		do {
			try {
				repetir = false;
				i = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				s.nextLine();
				repetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (repetir);
		
		s.nextLine();
		
		return i;
	}
	
	public static double leerDouble() {
		double i = 0;
		boolean repetir;
		
		do {
			try {
				repetir = false;
				i = s.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número");
				s.nextLine();
				repetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (repetir);
		
		s.nextLine();
		
		return i;
	}

}
