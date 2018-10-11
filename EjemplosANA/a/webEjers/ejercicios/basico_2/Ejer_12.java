package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_12 {
/*
	Ejercicio 12:
		Programa Java que lea un número entero N de 5 cifras y muestre sus cifras igual que en el
		ejemplo.
		Por ejemplo para un número N = 12345 La salida debe ser:
		5
		45
		345
		2345
		12345
		*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.print("Introduzca valor de 5 cifras: ");
		
		N = sc.nextInt(); //supondremos que el número introducido tiene 5 cifras
		
		while(N<10000) {
			System.out.println("Numero de 5 cifras por favor");
			N = sc.nextInt();
		}
		
		//Muestra las primeras cifras
		System.out.println(N/10000);
		System.out.println(N/1000);
		System.out.println(N/100);
		System.out.println(N/10);
		System.out.println(N);
		
		//Muestra las ultimas cifras
		System.out.println(N%10);
		System.out.printf("%02d %n",N%100);
		System.out.printf("%03d %n",N%1000);
		System.out.printf("%04d %n",N%10000);
		System.out.printf("%05d %n",N);
		
		sc.close();
	}

}
