package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa que lee una temperatura expresada en grados centígrados y los pasa a grados kelvin. 
 * Repetir el proceso mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 */
public class e03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double temperatura;
        char caracter;
        do{
            System.out.print("Introduce la temperatura en grados centígrados: ");
            temperatura = sc.nextDouble();
            System.out.println("Grados Kelvin: " + (temperatura+273));
            System.out.print("Repetir proceso? (S/N) " );
            caracter = (char)System.in.read();
        }while(caracter =='S');
        
        sc.close();
	}

}
