package a.webEjers.ejercicios.basico.condicional;

import java.util.Scanner;

public class Ejer_2_isMultiplo {
/*
 * 2. Programa que lea un número entero y muestre si el número es múltiplo de 10.
Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de
esta división es cero.
 */
	public static void main(String[] args) {
		System.out.print("Introduce un numero: ");
		Scanner sc=new Scanner(System.in);
		
		int num_introd=sc.nextInt();
		
		if(num_introd%10==0) {
			System.out.println("Es multiplo de 10");
		}else {
			System.out.println("No es multiplo de 10");
		}
		sc.close();

	}

}
