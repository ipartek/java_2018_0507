package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerNumerosdeFichySuma {
	public static void main(String args[]) {
		File f = new File("a/webEjers/ejercicios/manejo_fichs_dirs/numeros.txt");
		int numero, suma = 0, cont = 0;
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(f);
			while (entrada.hasNextInt()) {
				numero = entrada.nextInt();
				System.out.println(numero);
				suma = suma + numero;
				cont++;
			}
			System.out.println("Número leídos: " + cont);
			System.out.println("Suma " + suma);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally{
			entrada.close();
		}
	}
}
