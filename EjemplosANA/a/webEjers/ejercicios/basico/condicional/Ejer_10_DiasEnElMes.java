package a.webEjers.ejercicios.basico.condicional;

import java.util.Scanner;

public class Ejer_10_DiasEnElMes {
/*
* Programa java que lea una variable entera mes y compruebe si el valor corresponde
* a un mes de 30 días. Se debe comprobar que el valor introducido esté
* comprendido entre 1 y 12
*/
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mes=0;
		
		do {
			System.out.println("Introduzca mes(1-12): ");
			mes=sc.nextInt();
			
			switch(mes){ //se muestra el nombre mediante una instrucción switch
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
				default:
					System.out.println("Introduzca mes(1-12): ");
					mes=sc.nextInt();
					
			}
			
		}while(mes<1 || mes >12);
		
		// mostrar si es un mes de 30, 31 0 28 días
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
			System.out.println(" es un mes de 30 días");
		else if(mes == 2)
			System.out.println(" es un mes de 28 días");
		else
			System.out.println(" es un mes de 31 días");
		
		sc.close();
	}

}
