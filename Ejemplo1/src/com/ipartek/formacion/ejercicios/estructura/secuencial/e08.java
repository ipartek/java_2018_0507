package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* 8:
Programa que tome como dato de entrada un número que corresponde a la longitud del radio una esfera 
y nos calcula y escribe el volumen de la esfera que se corresponden con dicho radio.

La fórmula para calcular el volumen de la esfera es 
v = (4/3)*PI*r^3
*/

public class e08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Introduce la longitud del radio: ");
		Scanner sc = new Scanner(System.in);
		double longitudRadioEsfera = sc.nextDouble();
		System.out.println("El volumen de la esfera es: " + ((3.0/4)*Math.PI*Math.pow(longitudRadioEsfera,3)));
		sc.close();

	}

}
