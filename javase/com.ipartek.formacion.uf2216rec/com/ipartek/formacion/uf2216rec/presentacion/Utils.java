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
	
	public static int leerMemoria() {
		int i = 0;
		
		do {
			try {
				System.out.println("Por favor, introduce la memoria, un número entero multiplo de 4");
				i = s.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce la memoria, un número entero multiplo de 4");
				s.nextLine();
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (i%4 != 0);
		
		s.nextLine();
		
		return i;
	}
	
	public static double leerRam() {
		double i = 0;
		
		do {
			try {
				System.out.println("Por favor, introduce un número mayor que 0,5 GB");
				i = s.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número mayor que 0,5 GB");
				s.nextDouble();
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (i < 0.50);
		
		s.nextLine();
		
		return i;
	}
	
	public static double leerPulgadas() {
		double i = 0;
		
		do {
			try {
				System.out.println("Por favor, introduce pulgadas, maximo 7,0");
				i = s.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce pulgadas, maximo 7,0");
				s.nextDouble();
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (i > 7.0);
		
		s.nextLine();
		
		return i;
	}


}
