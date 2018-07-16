package com.ipartek.formacion.ejercicios.estructura.condicional;
/* 2. Programa que lea un número entero y muestre si el número es múltiplo de 10.
Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10
es resto de esta división es cero. */

import java.util.Scanner;

public class e02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce un número entero: ");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();

		if (numero % 10 == 0)
			System.out.println("Es múltiplo de 10");
		else
			System.out.println("No es múltiplo de 10");

		sc.close();
	}

}
