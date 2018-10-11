package a.webEjers.ejercicios.basico.condicional;

import java.io.IOException;
import java.util.Scanner;

public class Ejer_7_Division {
/*
 * Ejercicio 7: Programa que lea dos números por teclado y muestre el resultado de la división
del primer número por el segundo. Se debe comprobar que el divisor no puede ser cero.
 */
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		double num1,num2;
		System.out.println("Introduzca dividendo: ");
		num1=sc.nextDouble();
	
		if(num1>0) {
			System.out.println("Introduzca divisor: ");
			num2=sc.nextDouble();
			if (num2>0) {
				System.out.println(num1/num2);
			}else
				System.out.println("No puede ser 0");
		}else
			System.out.println("No puede ser 0");
		sc.close();
	}
}
