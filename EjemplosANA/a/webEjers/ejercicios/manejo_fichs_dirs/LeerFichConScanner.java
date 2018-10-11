package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerFichConScanner {
	//Pag.141
	public static void main(String args[]) {
		File f = new File("a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt");
		String cadena;
		Scanner entrada = null;
		try {
			entrada = new Scanner(f); //se crea un Scanner asociado al fichero
			while (entrada.hasNext()) { //mientras no se alcance el final del fichero
				cadena = entrada.nextLine(); //se lee una línea del fichero
				System.out.println(cadena); //se muestra por pantalla
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally{
			entrada.close();
		}
	}
}
