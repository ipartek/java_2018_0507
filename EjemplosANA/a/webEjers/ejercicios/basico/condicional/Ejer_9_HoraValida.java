package a.webEjers.ejercicios.basico.condicional;

import java.util.Scanner;

public class Ejer_9_HoraValida {
	/*Ejercicio 9:
Programa que lea por teclado tres números enteros H, M, S correspondientes a hora, minutos
y segundos respectivamente, y comprueba si la hora que indican es una hora válida.
Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor válido para las
horas será mayor o igual que cero y menor que 24.
El valor válido para los minutos y segundos estará comprendido entre 0 y 59 ambos incluidos*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H,M,S;
		
		do {
			System.out.println("Introduzca hora(0-23): ");
			H=sc.nextInt();
			while (H<0 || H>23) {
				System.out.println("Formato erroneo, hora debe ser entre 0 y 23");
				System.out.println("Introduzca de nuevo");
				H=sc.nextInt();}
		}while(H<0 || H>23);
		
		
		do {
			System.out.println("Introduzca min(59m): ");
			M=sc.nextInt();
			while (M<0 || M>59) {
				System.out.println("Formato erroneo, hora debe ser entre 0 y 23");
				System.out.println("Introduzca de nuevo");
				M=sc.nextInt();}
		}while(M<0 || M>59);
		
		do {
			System.out.println("Introduzca sec(59s): ");
			S=sc.nextInt();
			while (S<0 || S>59) {
				System.out.println("Formato erroneo, los segundos deben ser entre 0 y 59");
				System.out.println("Introduzca de nuevo");
				S=sc.nextInt();}
		}while(S<0 || S>59);
		
		
		System.out.println("La hora introducida es: "+ H+":"+M+":"+S);
		sc.close();

	}

}
