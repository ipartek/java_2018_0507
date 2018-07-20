package com.ipartek.formacion.uf2216.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	private static Scanner s = new Scanner(System.in);;

	/* Leer linea con clase Scanner y comprobaciones */
	public static String leerLinea() {
		String linea;
		boolean hayQueMostrarMensaje = false;
		
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

	/* Leer ISBN: 10 caracteres solo */
	public static String leerIsbn() {
		String linea;
		boolean hayQueMostrarMensaje = false;
		
		do {
			if(hayQueMostrarMensaje) {
				System.out.println("El ISBN tiene que ser de 10 letras");
			}
			
			linea = s.nextLine().trim();
			
			hayQueMostrarMensaje = true;
		} while(linea.length() == 0);

		return linea;
	}
	
	/* Leer formato: digital o papel solo*/
	public static int leerFormato() {
		String linea;
		boolean hayQueMostrarMensaje = false;
		int formatoCorreto = 0;
		
		do {
			if(hayQueMostrarMensaje) {
				System.out.println("No cuela con texto en blanco");
			}
			
			linea = s.nextLine();
			
			hayQueMostrarMensaje = true;
		} while(linea.length() == 0);

		formatoCorreto = transformarFormato(linea);
		
		return formatoCorreto;
	}
	
	/* Funcion para transformar Formato (digital o papel) true == digital, false == papel
	 *  0: formato incorrecto
	 *  1: digital
	 *  2: papel
	 */
	
	private static int transformarFormato(String formato) {
		int resul = 0;
		if (formato.trim().equalsIgnoreCase("digital")){
			resul = 1;
		}else if (formato.trim().equalsIgnoreCase("papel")) {
			resul = 2;
		}
		
		return resul;
	}
	
}
