package a.webEjers.ejercicios.basico.condicional;

import java.util.Scanner;
//Pagina 23
public class Ejer_8_MayordeTresNums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1,num2,num3,mayor;
		
		System.out.println("Introduzca num1: ");
		num1=sc.nextInt();
		System.out.println("Introduzca num2: ");
		num2=sc.nextInt();
		System.out.println("Introduzca num3: ");
		num3=sc.nextInt();
		
		if (num1 > num2) {
			if (num1 > num3) 
				mayor=num1;
			else 
				mayor=num3;
		} else {
			if (num2 > num3) 
				mayor=num2;
			else 
				mayor=num3;
		}
		System.out.println("Numero mayor: "+mayor);
		sc.close();
	}

}
