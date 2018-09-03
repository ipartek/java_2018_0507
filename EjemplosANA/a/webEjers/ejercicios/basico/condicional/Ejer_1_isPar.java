package a.webEjers.ejercicios.basico.condicional;

import java.util.Scanner;

public class Ejer_1_isPar {
/*
 * 1. Programa Java que lea un número entero por teclado y calcule si es par o impar.
Podemos saber si un número es par si el resto de dividir el número entre 2 es igual a cero. En
caso contrario el número es impar
El operador Java que calcula el resto de la división entre dos números enteros o no es el
operador %
 */
	public static void main(String[] args) {
		System.out.print("Introduce un numero: ");
		Scanner sc=new Scanner(System.in);
		
		int num_introd=sc.nextInt();
		
		if(num_introd%2==0) {
			System.out.println("Par");
		}else {
			System.out.println("Impar");
		}
		sc.close();
	}

}
