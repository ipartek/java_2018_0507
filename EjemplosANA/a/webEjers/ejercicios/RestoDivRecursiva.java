package a.webEjers.ejercicios;

import java.util.Scanner;

public class RestoDivRecursiva {
	//132
	/*Calcular el resto de la división de forma recursiva
	Programa que calcula el resto de la división de dos números enteros de forma recursiva.
	El planteamiento para resolverlo es el siguiente:
	Caso Base: Si el dividendo es menor que el divisor, el resto es el dividendo.
	Si el caso base no se cumple, entonces se resta el dividendo y el divisor. A este resultado se le
	vuelve a restar el divisor. Este proceso se repite hasta que se llega al caso base, es decir,
	cuando el resultado obtenido al restar sea menor que el divisor.
	Con un ejemplo quedará más claro:
	Supongamos que queremos calcular el resto de dividir 10 entre 3:
	Restamos 10 – 3 Resultado 7
	Restamos 7 – 3 Resultado: 4
	Restamos 4 -3 Resultado: 1
	Como 1 es menor que 3 no se realiza la operación. El resto de la división es 1.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		System.out.print("Introduzca dividendo: ");
		n1 = sc.nextInt();
		do {
			System.out.print("Introduzca divisor (>0): ");
			n2 = sc.nextInt();
		} while (n1 <= 0);
		System.out.printf("%d%%%d = %d %n", n1, n2, restoRecursivo(n1, n2));
		sc.close();
	}
	//método que calcula el resto de la división de forma recursiva
	public static int restoRecursivo(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return restoRecursivo(a - b, b);
		}
	}
}
