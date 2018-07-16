package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/*3. Programa que lea un carácter por teclado y compruebe si es una letra mayúscula*/

public class e03 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        char caracter;
        System.out.print("Introduce un carácter: ");
        caracter = (char)System.in.read();
        if (Character.isUpperCase(caracter))
        	System.out.println("Es MAYÚSCULA");
        else System.out.println("Es minúscula");
        
        
        sc.close();
	}
}
