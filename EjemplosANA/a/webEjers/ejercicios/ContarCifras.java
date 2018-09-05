package a.webEjers.ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class ContarCifras {
/*Contar las cifras de un número entero en Java
Programa Java que pide un número entero por teclado y calcula y muestra el número de cifras
que tiene.
Por ejemplo si se introduce el número 54391 el programa mostrará el mensaje:
El número tiene 5 cifras
Si se introduce el número 101 se mostrará el mensaje:
El número tiene 3 cifras
El proceso leer un número y contar sus cifras se repetirá hasta que se conteste ‘N’ a la
pregunta Continuar? (S/N)
Si se responde 'S' se volverá a pedir otro número.
Para saber cuántas cifras tiene un número entero haremos lo siguiente:
Dividiremos el número sucesivamente entre 10. En cada división tomaremos la parte entera y
volvemos a dividir. Este proceso se repite hasta que se obtenga un cero como cociente en la
división.
Por ejemplo, si el número leído es 1234 haremos las siguientes operaciones:
1234 / 10 = 123
123 / 10 = 12
12 / 10 = 1
1 / 10 = 0
hemos realizado 4 divisiones hasta obtener un cero como cociente, por lo tanto el número
tiene 4 cifras.*/
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n, cifras;
		char car;
		
		do{
			System.out.print("Introduce un número entero: ");
			n = sc.nextInt();
			cifras= 0; 
			while(n!=0){ //mientras a n le queden cifras
				n = n/10; //le quitamos el último dígito
				cifras++; //sumamos 1 al contador de cifras
			}
			System.out.println("El número tiene " + cifras+ " cifras");
			System.out.print("Continuar? ");
			car = (char)System.in.read();
		}while(car!='n' && car != 'N');
	
		sc.close();
	}

}
