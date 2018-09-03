package a.webEjers.ejercicios;

import java.util.Scanner;

/*
 * 1. Calcular la media de una serie de números que se leen por teclado.
Programa Java que lea por teclado 10 números enteros y los guarde en un array. A
continuación calcula y muestra por separado la media de los valores positivos y la de los
valores negativos.
 */
public class MediaDeNumerosLeidosTeclado {

	public static void main(String[] args) {
		int[] numeros=new int[10];
		int sumapos=0;
		int sumaneg=0;
		int contpos=0;
		int contneg=0;
		
		Scanner sc = new Scanner(System.in);
		
	
		for (int i=0;i<10;i++) {
			System.out.println("Introduce numero(pos/neg: ");
			numeros[i]=sc.nextInt();
		}
		
		for (int i=0;i<10;i++) {
			if(numeros[i]>0) {
				sumapos=sumapos+numeros[i];
				contpos++;
			}
			if(numeros[i]<0) {
				sumaneg=sumaneg+numeros[i];
				contneg++;
			}
		}

		System.out.println("ContadorPosotivos"+sumapos+" ContadorNegativos"+sumaneg);
		
		//Medias
		
		System.out.println("Media de positivos: "+sumapos/contpos);
		System.out.println("Media de negativos: "+sumaneg/contneg);
		
		sc.close();
	}

}
