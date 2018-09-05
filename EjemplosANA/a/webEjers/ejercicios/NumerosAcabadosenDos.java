package a.webEjers.ejercicios;

import java.util.Scanner;

public class NumerosAcabadosenDos {
/*
 * Programa que lea una serie de números por teclado hasta que se lea un número negativo. El
programa indicará cuántos números acabados en 2 se han leído.
Para saber si un número acaba en dos o en general para saber en qué dígito termina un
número entero se divide el número entre 10 y se obtiene el resto de esta división.
En Java el operador que obtiene el resto de una división es el operador %
En este caso para saber si el número acaba en 2 escribiremos la instrucción:
if(n%10==2)
 */
	public static void main(String[] args) {
		int num=0;
		Scanner sc = new Scanner(System.in);
		int cont=0;
		
		do {
			System.out.println("Introduzca numero: ");
			num=sc.nextInt();
			if(num%10==2)
				cont++;
		}while (num>=0);
		
		System.out.println("Contador de numeros acabados en dos:"+cont);
		sc.close();
	}
}
