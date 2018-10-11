package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_11 {
/*
 * Ejercicio 11: Pag.13
Programa que lea un número entero N de 5 cifras y muestre sus cifras igual que en el ejemplo.
Por ejemplo para un número N = 12345 La salida debe ser:
1
12
123
1234
12345
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.print("Introduzca valor de 5 cifras: ");
		
		N = sc.nextInt(); //supondremos que el número introducido tiene 3 cifras
		
		while(N<10000) {
			System.out.println("Numero de 5 cifras por favor");
			N = sc.nextInt();
		}
		System.out.println(N/10000);
		System.out.println(N/1000);
		System.out.println(N/100);
		System.out.println(N/10);
		System.out.println(N);
		
		
		sc.close();
	}

}
