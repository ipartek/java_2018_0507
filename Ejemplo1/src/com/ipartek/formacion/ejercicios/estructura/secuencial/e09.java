package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/* 9:
Programa Java que calcule el área de un triángulo en función de las longitudes de sus lados (a, b, c), 
según la siguiente fórmula:  
	Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
	donde p =  (a+b+c)/2
Para calcular la raíz cuadrada se utiliza el método Math.sqrt()  */

public class e09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la longitud del lado A: ");
		double ladoA = sc.nextDouble();
		System.out.println("Introduce la longitud del lado B: ");
		double ladoB = sc.nextDouble();
		System.out.println("Introduce la longitud del lado C: ");
		double ladoC = sc.nextDouble();
		
		double p = ((ladoA+ladoB+ladoC)/2);
		System.out.println("El área del triángulo es: " + Math.sqrt(p*(p-ladoA)*(p-ladoB)*(p-ladoC)));
		sc.close();
	}

}
