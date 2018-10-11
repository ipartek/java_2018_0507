package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerNumerosIntDouble {
	public static void main(String[] args) {
		int numeroEntero, sumaInt = 0;
		double numeroDouble, sumaDouble = 0;
		File f = new File("a/webEjers/ejercicios/manejo_fichs_dirs/numerosIntDouble.txt");
		try (Scanner entrada = new Scanner(f)) {
			//Primero están todos los int seguidos
			System.out.println("Números de tipo int: ");
			while (entrada.hasNextInt()) { //mientras queden enteros por leer
				numeroEntero = entrada.nextInt(); //se lee un entero del archivo
				System.out.print(numeroEntero + " "); //se muestra por pantalla
				sumaInt = sumaInt + numeroEntero; //se suma
			}
			//cuando acaba la lectura de enteros se muestra su suma
			System.out.println("\nSuma de los int: " + sumaInt);
			
			//Cuando terminan los int empiezan los double
			System.out.println("Números de tipo double: ");
			while (entrada.hasNextDouble()) { //mientras queden double por leer
				numeroDouble = entrada.nextDouble(); //se lee un double del archivo
				System.out.print(numeroDouble + " "); //se muestra por pantalla
				sumaDouble = sumaDouble + numeroDouble; //se suma
			}
			//cuando acaba la lectura de double se muestra su suma
			System.out.println("\nSuma de los doubles: " + sumaDouble);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
