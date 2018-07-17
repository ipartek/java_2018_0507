/*
 * Clase Menu que recorre un switch para preguntar el ejercicio que se desea ejecutar,
 * y que una vez ejecutado pregunta si quiere volver a ejecutarse. En caso de no introducir un
 * valor valido para el switch vuelve a preguntarlo.
 */
package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Menu {
	
	public static String letter;
	public static char caracter;
	public static boolean salir = true;
	public static String def;
	public static int menu;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static LeerTeclado lt2 = new LeerTeclado(sc2);
	static Ejercicio1 e1 = new Ejercicio1();
	static Ejercicio2 e2 = new Ejercicio2(sc2);
	static Ejercicio3 e3 = new Ejercicio3();
	static Ejercicio10 e10 = new Ejercicio10(sc2);
	static EjercicioIterativo1 ei1 = new EjercicioIterativo1();
	static EjercicioArrayList1 eal1 = new EjercicioArrayList1(sc);
	static EjercicioFicherosDirectorios1 efd1 = new EjercicioFicherosDirectorios1();
	static EjercicioFicherosDirectorios2 efd2 = new EjercicioFicherosDirectorios2(sc2);
	
	public static void menu() {
		do {
			salir = true;
			System.out.println("Elige que ejercicio quieres ejecutar");
			menu = lt.leerInt(menu);
			switch(menu){
				case 1: e1.leerNumero();
				volver();
				break;
				case 2: e2.leerNombre();
				volver();
				break;
				case 3: e3.resultado();
				volver();
				break;
				case 4: e10.cortarNumero();
				volver();
				break;
				case 5: ei1.mostrarNumeros1();
				volver();
				case 6: eal1.numeroAlumnos();
				break;
				case 7: efd1.mostrarUnidadesDisco();
					volver();
					break;
				case 8: efd2.leerDirectorio();
					volver();
					break;
				default:
					salir = false;
					System.out.println("Eleccion no valida");
					break;
			}
		}while (salir==false);
	}
	public static void volver() {
		System.out.println("\nQuieres volver al menu? S/N");
		leerSN();
		if(caracter == 's' || caracter == 'S') {
			menu();
		}else if (caracter == 'n' || caracter == 'N'){
			System.out.println("Adios");
		}else {
			volver();
		}
	}
	
	public static void leerSN(){
		letter = lt2.leerChar(letter);
		caracter = letter.charAt(0);
	}
}
