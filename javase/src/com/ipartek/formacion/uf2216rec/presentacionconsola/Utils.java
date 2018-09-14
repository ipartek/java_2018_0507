package com.ipartek.formacion.uf2216rec.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	private static Scanner s = new Scanner(System.in);
	
	public static String leerLinea() {
		String linea;
		boolean hayQueMostrarMensaje = false;
		
		do {
			if(hayQueMostrarMensaje) {
				System.out.println("Texto en blanco");
			}
			
			linea = s.nextLine().trim();
			
			hayQueMostrarMensaje = true;
		}while (linea.length() == 0);
		
		return linea;
	}
	
	
	public static double leerDouble() {
		double d = 0.0;
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				d = s.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("Por favor, introduce un numero que tenga el formato valido.");
				s.nextLine();
				hayQueRepetir = true;
			}catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		}while (hayQueRepetir);
		s.nextLine();
		
		return d;
	}
	
	public static int leerInt() {
		int i = 0;
		boolean hayQueRepetir;
	
		do {
			try {
				hayQueRepetir = false;
				i = s.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Porfavor, introduce un numero que sea valido.");
				s.nextLine();
				hayQueRepetir = true;
			}catch(Exception e ) {
				System.out.println("Error no esperado");
				throw e;
			}
		}while(hayQueRepetir);
		s.nextLine();
		
		return i;
	}


	public static Boolean leerBoolean() {
		boolean b = false;
		boolean hayQueRepetir;

		
		do {
			try {
			hayQueRepetir = false;
			b = s.nextBoolean();
			}catch (RuntimeException e) {
				System.out.println("Porfavor, introduce True o False.");
				s.nextLine();
				hayQueRepetir = true;
			}catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		}while (hayQueRepetir);
		s.nextLine();
		
		return b;
	}
}
