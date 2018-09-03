package a.webEjers.ejercicios;

import java.util.Scanner;

public class Elevar2a_n2 {

	
	
	
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
		double resultado=1;
		int i;
		for(i=1;i<=n;i++)
			resultado = resultado * 2;
	return resultado;
	}
}
