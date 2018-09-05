package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_5_LongyArea_Circun {
 /*
 * Ejercicio 5. Programa que lee por teclado el valor del radio de una circunferencia y calcula y
muestra por pantalla la longitud y el área de la circunferencia.
Longitud de la circunferencia = 2*PI*Radio, 
Area de la circunferencia = PI*Radio^2
 */
	public static void main(String[] args) {
		
		System.out.println("*********Longitud y Area de Circunferencia*********");
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.print("Introduce el radio de la circunferencia: ");
		int radio_circun=sc.nextInt();
		System.out.println();
		//Longitud de la circunferencia = 2*PI*Radio
		double longitud_circun= 2 * Math.PI * radio_circun;
		//Area de la circunferencia = PI*Radio^2
		double area_circun= Math.PI*Math.pow(radio_circun, 2);
		
		System.out.println("Longitud Circunferencia: "+longitud_circun);
		System.out.println("Area Circunferencia: "+area_circun);
		
		sc.close();
		
	}

}
