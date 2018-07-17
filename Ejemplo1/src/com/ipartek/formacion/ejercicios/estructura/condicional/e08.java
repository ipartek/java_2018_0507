package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/* Calcular el mayor de tres números enteros en Java.
El programa lee por teclado tres números enteros y calcula y muestra el mayor de los tres. */

public class e08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el primer número: ");
		int numero1 = sc.nextInt();
		System.out.println("Introduce el segundo número: ");
		int numero2 = sc.nextInt();
		System.out.println("Introduce el tercer número: ");
		int numero3 = sc.nextInt();
		
		if (numero1 > numero2)
			if (numero1>numero3) System.out.println("El mayor es: " + numero1);
			else System.out.println("El mayor es: " + numero3);
		else if (numero2>numero3) System.out.println("El mayor es: " + numero2);
		else System.out.println("El mayor es: " + numero3);
		
		sc.close();
	}
}
