/*
 * Clase desde la que se llama a los metodos de lectura del teclado.
 */
package com.ipartek.formacion.video.presentacionconsola;

import java.util.InputMismatchException;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerTeclado {
	public boolean reEjecutar= true;
	public static Scanner sc = new Scanner(System.in);
	
	public LeerTeclado(Scanner sc) {
		super();
		this.sc = sc;
	}
	public String leerString(String s) {
		boolean mostrarMensaje = false;
		do {
			if(mostrarMensaje) {
			System.out.println("No cuela con mensaje en blanco");
			}
			s = sc.nextLine().trim();
			mostrarMensaje = true;
		}while (s.length() == 0);
		return s;
	}	
	
	public static long leerLong(long l) {
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				l = sc.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				sc.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (hayQueRepetir);
		
		sc.nextLine();
		
		return l;
	}

	public static int leerInt(int i) {
		boolean hayQueRepetir;
		
		do {
			try {
				hayQueRepetir = false;
				i = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número entero sin comas ni puntos");
				sc.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (hayQueRepetir);
		
		sc.nextLine();
		
		return i;
}
	
	public String leerChar(String l) {
		return l = sc.nextLine();
	}
	public Double leerDoble(Double d) {
		boolean hayQueRepetir;
		do {
			try {
				hayQueRepetir = false;
				d = sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, introduce un número");
				sc.nextLine();
				hayQueRepetir = true;
			} catch (Exception e) {
				System.out.println("Error no esperado");
				throw e;
			}
		} while (hayQueRepetir);
		
		sc.nextLine();
		
		return d= sc.nextDouble();
	}
}
