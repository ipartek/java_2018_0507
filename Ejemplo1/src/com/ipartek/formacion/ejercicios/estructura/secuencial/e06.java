package com.ipartek.formacion.ejercicios.estructura.secuencial;
/* 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 */

import java.util.Scanner;

public class e06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduce la velocidad en Km/h: ");
		Scanner sc = new Scanner(System.in);
		Double velocidad = sc.nextDouble();

		System.out.println("La velocidad en m/s es:");
		System.out.println(velocidad * 1000 / 3600);

	}

}
