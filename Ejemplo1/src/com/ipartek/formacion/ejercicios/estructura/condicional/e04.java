package com.ipartek.formacion.ejercicios.estructura.condicional;
import java.io.IOException;
/* 4: Programa que lea dos caracteres y compruebe si son iguales. */
import java.util.Scanner;

public class e04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        char caracter1;
        char caracter2;
        System.out.print("Introduce un carácter: ");
        caracter1 = (char) System.in.read();
        System.in.read(); System.in.read(); //meto dos read xq en windows los saltos de linea son dos caracteres
        System.out.print("Introduce otro carácter: ");
        caracter2 = (char)System.in.read();
        
        
        if (caracter1==caracter2)
        	System.out.println("Son iguales");
        else System.out.println("Son diferentes");
        
        
        sc.close();
	}

}
