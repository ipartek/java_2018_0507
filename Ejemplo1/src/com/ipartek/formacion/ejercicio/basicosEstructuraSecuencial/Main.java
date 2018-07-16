package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Main {

	public static int menu;
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	
	public static void main(String[] args) {
		LeerTeclado lt = new LeerTeclado(sc);
		Ejercicio1 e1 = new Ejercicio1();
		Ejercicio2 e2 = new Ejercicio2(sc2);
		
		System.out.println("Elige que ejercicio quieres ejecutar");
		menu = lt.leerInt(menu);
		switch(menu){
			case 1: e1.leerNumero();
			break;
			case 2: e2.leerNombre();
			break;
		
			
		}
		//e1.leerNumero();
		
	}

}
