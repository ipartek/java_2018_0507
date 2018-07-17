package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que
 * se lea un número negativo. El programa indicará cuántos números 
 * acabados en 2 se han leído.
 */
public class e05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		int contador = 0;
		
		while (numero>=0) {
		System.out.println("Introduce un número: ");
		numero = sc.nextInt();
		if (numero%10==2) contador++;
		
		}
		
		System.out.println("Números positivos acabados en 2 introducidos: " + contador);
		sc.close();

	}

}
