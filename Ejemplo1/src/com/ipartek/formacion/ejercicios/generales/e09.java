package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que pasa un número de decimal a binario
 */
public class e09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero;
		int potencia;
		int digito;
		int binario;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero entero: ");
			numero = sc.nextInt();
		} while (numero < 0);

		potencia = 0;
		binario = 0;
		while (numero != 0) {
			digito = numero % 2;
			binario = (int) (binario + digito * Math.pow(10, potencia));
			potencia++;
			numero = numero / 2;
		}
		System.out.printf("Binario: " + binario);

		sc.close();

	}

}
