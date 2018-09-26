package com.ipartek.formacion.uf2216.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String leerLinea() {
		String linea;
		boolean mensaje = false;
		
		do {
			if(mensaje) {
				System.out.println("No se ha introducido ningun caracter valido");
			}
			
			linea = sc.nextLine().trim();
			
			mensaje = true;
		}while (linea.length() == 0);
		
		return linea;
	}
	
	
	public static long leerLong() {
		long l = 0;
		boolean repe = false;
		
		do {
			try {
				repe = false;
				l = sc.nextLong();
			}catch (InputMismatchException e) {
				System.out.println("Porfavor introduce una respuesta valida. ");
				sc.nextLine();
				repe = true;
			}catch(Exception e) {
				System.out.println("Error inesperado");
			}
		}while (repe);
		sc.nextLine();
		return l;
	}
	
	
	public static int leerInt() {
		int i = 0;
		boolean repe;
		
		do {
			try {
				repe = false;
				i = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("Por favor, introduce una respuesta valida");
				sc.nextLine();
				repe = true;
			}catch (Exception e) {
				System.out.println("Error Inesperado");
				throw e;
			}
		}while (repe);
		sc.nextLine();
		
		return i;
	}
	
	
}
