package a.webEjers.ejercicios;

import java.util.Scanner;

public class Elevar2a_n {
	/*Programa Java recursivo para calcular 2 elevado a n siendo n un número entero mayor o igual
	que 0.
	La solución recursiva se basa en lo siguiente:
	Caso Base:
	si n = 0 entonces 2^0 = 1
	Si n > 0 Podemos calcular 2^n como 2 * 2^n-1
	Por ejemplo: 2^5 = 2 * 2^4
	*/
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		do{
			System.out.print("Introduce un numero entero >=0 ");
			num = sc.nextInt();
		}while(num<0);
		
		System.out.println("2 ^ " + num + " = " + potencia(num));
		sc.close();
	}
	
	public static double potencia(int n){
		if(n==0) //caso base
			return 1;
		else
			return 2 * potencia(n-1);
	}
}
