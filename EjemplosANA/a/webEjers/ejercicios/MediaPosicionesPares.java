package a.webEjers.ejercicios;

import java.util.Scanner;

public class MediaPosicionesPares {
/*
 * 2. Programa Java que lea 10 números enteros por teclado y los guarde en un array. Calcula y
muestra la media de los números que estén en las posiciones pares del array
 */
	public static void main(String[] args) {
		int[] arrayNums=new int[10];
		int media=0;
	
		
		Scanner sc = new Scanner(System.in);
		for (int cont=0;cont<10;cont++) {
			System.out.print("Introduce un numero entero >= 0: ");
			arrayNums[cont]= sc.nextInt();
		}

		
		for (int i=0;i<10;i++)
			System.out.println(arrayNums[i]);
		
		
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0){ //si la posición actual es par
				media = media + arrayNums[i]; //se suma el valor de esa posición
			}
		}
		//Calcular y mostrar la media
		System.out.println("Media de los valores que se encuentran en posiciones pares: "+media/5);
		sc.close();
	}

}
