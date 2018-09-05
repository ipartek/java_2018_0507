package a.webEjers.ejercicios;

import java.util.Scanner;

/*2. Leer por teclado un número entero N no negativo y mostrar la suma de los factoriales de
todos los números desde 0 hasta N.*/

public class SumaFactorial {
	public static void main(String[] args) {
		int N;
		double factorial, suma = 0;
		Scanner sc = new Scanner(System.in);
//Leer un número entero >= 0
		do {
			System.out.print("Introduce un número > 0: ");
			N = sc.nextInt();
		} while (N < 0);
		for (int i = 0; i <= N; i++) { // para cada número desde 1 hasta N
//se calcula su factorial
			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}
//se muestra el factorial
			System.out.printf("%n%2d! = %.0f %n", i, factorial);
//se suma el factorial o
			suma = suma + factorial;
		}
//Al final del proceso se muestra la suma de todos los factoriales
		System.out.printf("Suma de los factoriales desde 0 hasta %d: %.0f%n", N, suma);
		sc.close();
	}
}
