//Programa Java que lea un nombre y muestre por pantalla: �Buenos dias nombre_introducido�.

package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio2 extends LeerTeclado{

	public String name;
	
	public Ejercicio2(Scanner sc) {
		super(sc);
	}

	public void leerNombre() {
		System.out.println("Introduzca su nombre.");
		name = leerString(name);
		System.out.println("Buenos dias " + name);
	}
	
	
}