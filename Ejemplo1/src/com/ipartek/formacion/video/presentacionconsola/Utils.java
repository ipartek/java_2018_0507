package com.ipartek.formacion.video.presentacionconsola;

import java.util.InputMismatchException;
import java.util.Scanner;

//funciones generales que necesitare en muchos sitios

public class Utils {
	private static Scanner s = new Scanner (System.in);
	
	public static String leerLinea() { 
		String linea;
		boolean hayQueMostrarMensaje = false; //solo lo haga cuando haya pasado
		
		do {
			//si paso esta linea, para que salga en cuanto pase
			if(hayQueMostrarMensaje) {
				System.out.println("No cuela con texto en blanco");
			}
			
			linea = s.nextLine().trim(); //leo la linea y quito los espacio que tenga en los laterales
			hayQueMostrarMensaje = true;
			
		}while ( linea.length() == 0 ); //para que rellene algo y no lo pueda dejar en blanco
		
		return linea;
	}
	
	public static long leerLong() {
		long l = s.nextLong();
		s.nextLine();
		return l;
	}
	
	public static int leerInt() {
		int i = 0;
		boolean hayQueRepetir;
		
		do {
			try { 
				hayQueRepetir = false;
				i = s.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("Por davor, introduce un numero entero sin comas ni puntos");
				s.nextLine(); //asi vacío el buffer del escaner
				hayQueRepetir = true;
			}catch (Exception e) { //si ocurre un error inesperado
				System.out.println("Error no esperado");
				throw e;
			}
		}while(hayQueRepetir);
		
		s.nextLine();
		return i;
	}

}
