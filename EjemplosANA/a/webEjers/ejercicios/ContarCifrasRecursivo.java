package a.webEjers.ejercicios;

import java.util.Scanner;

public class ContarCifrasRecursivo {
//Pagin.128

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do{
			System.out.print("Introduce un numero entero >0 ");
			num	 = sc.nextInt();
		}while(num<=0);
		System.out.println("Número de cifras: " + numeroCifras(num));
		sc.close();
	}
	public static int numeroCifras(int n){
		if(n < 10) //caso base
			return 1;
		else
			return 1 + numeroCifras(n/10);
	}
}
