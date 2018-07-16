package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* Programa Java que lea un número entero de 3 cifras y muestre por separado las cifras del número. */
public class e10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero de tres cifras: ");
		
		int numero = sc.nextInt();
		
		
		System.out.println("Centena: "  + (numero / 100));
		System.out.println("Decena: " + (numero / 10) % 10);
		System.out.println("Unidad: " + (numero % 10));
		
		sc.close();
	}

}
