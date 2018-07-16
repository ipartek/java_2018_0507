package com.ipartek.formacion.ejercicios.estructura.secuencial;
/* 12: Programa Java que lea un número entero N de 5 cifras y muestre sus cifras igual que en el ejemplo.
Por ejemplo para un número N = 12345    La salida debe ser:

5
45
345
2345
12345 */

import java.util.Scanner;

public class e12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero de 5 cifras: ");

		int numero = sc.nextInt();

		System.out.println((numero % 10));
		System.out.println((numero % 100));
		System.out.println((numero % 1000));
		System.out.println((numero % 10000));
		System.out.println((numero % 100000));
		sc.close();
	}

}
