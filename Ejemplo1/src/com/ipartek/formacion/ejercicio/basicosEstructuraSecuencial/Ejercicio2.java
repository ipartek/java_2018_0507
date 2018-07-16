package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio2 extends LeerTeclado{

	public String name;
	LeerTeclado lt = new LeerTeclado(sc);
	
	public Ejercicio2(Scanner sc) {
		super(sc);
		// TODO Auto-generated constructor stub
	}


	
	public void leerNombre() {
		System.out.println("Introduzca su nombre.");
		leerString(name);
		System.out.println("Su nombre es " + name);
		
	}
}
