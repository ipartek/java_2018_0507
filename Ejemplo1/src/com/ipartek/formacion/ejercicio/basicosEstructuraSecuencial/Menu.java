package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Menu {
	
	public static char letter;
	public static boolean salir = true;
	public static String def;
	public static int menu;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static LeerTeclado lt = new LeerTeclado(sc);
	static Ejercicio1 e1 = new Ejercicio1();
	static Ejercicio2 e2 = new Ejercicio2(sc);
	static Ejercicio3 e3 = new Ejercicio3();
	static Ejercicio10 e10 = new Ejercicio10(sc);
	
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
				default:
					salir = false;
					System.out.println("Valor no valido");
					break;
			}
		}while (salir==false);
	}
	public static void volver() {
		System.out.println("\nQuieres volver al menu? S/N");
		lt.leerChar(letter);
		System.out.println(letter);
		if(letter == 's' || letter == 'S' || letter == 'n' || letter == 'N') {
			System.out.println("gato");
			//menu();
		}else {
			System.out.println("Introduzca S o N");
		}
	}
	
}
