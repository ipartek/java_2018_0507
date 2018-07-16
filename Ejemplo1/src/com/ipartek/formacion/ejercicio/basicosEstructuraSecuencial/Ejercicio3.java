package com.ipartek.formacion.ejercicio.basicosEstructuraSecuencial;

import java.util.Scanner;

public class Ejercicio3 {
	public int valor;
	public int doble;
	public int triple;
	Scanner sc = new Scanner(System.in);
	LeerTeclado lt  = new LeerTeclado(sc);

	public void resultado() {
		valor = lt.leerInt(valor);
		System.out.println("Introduce un numero");
		doble =valor*2;
		triple= valor*3;
		System.out.println("El doble de " + valor + "es " + doble + ", y el triple es " + triple);
	}
	
}
