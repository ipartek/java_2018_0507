package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Calendar;
import java.util.Scanner;

/* 10: Programa que lea una variable entera mes y compruebe si el valor corresponde a un mes de 30 días,
de 31 o de 28. Supondremos que febrero tiene 28 días. Se mostrará además el nombre del mes.
Se debe comprobar que el valor introducido esté comprendido entre 1 y 12. */

public class e10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce una variable entera para el mes: ");
		Scanner sc = new Scanner(System.in);
		int mes = sc.nextInt();

		if (mes < 1 || mes > 12)
			System.out.println("No es un mes");
		else {
			switch (mes) {
			case 1:
				System.out.print("Enero");
				break;
			case 2:
				System.out.print("Febrero");
				break;
			case 3:
				System.out.print("Marzo");
				break;
			case 4:
				System.out.print("Abril");
				break;
			case 5:
				System.out.print("Mayo");
				break;
			case 6:
				System.out.print("Junio");
				break;
			case 7:
				System.out.print("Julio");
				break;
			case 8:
				System.out.print("Agosto");
				break;
			case 9:
				System.out.print("Septiembre");
				break;
			case 10:
				System.out.print("Octubre");
				break;
			case 11:
				System.out.print("Noviembre");
				break;
			case 12:
				System.out.print("Diciembre");
				break;
			}
		}
		
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7|| mes == 8|| mes == 10|| mes == 12)       
            System.out.println("Tiene 31 días");
         else if(mes == 2)
                  System.out.println("Tiene 28 días");
                else
                   System.out.println("Tiene 30 días");
        
		sc.close();

	}

}
