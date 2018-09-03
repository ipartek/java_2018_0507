package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Pag.140
public class LeerFichxCaracter {
	
	public static void main(String args[]) {
		FileReader fr = null;
		try {
			fr = new FileReader("a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			int car = entrada.read(); //se lee el primer carácter del fichero
		
			while (car != -1) { //mientras no se llegue al final del fichero
				System.out.print((char) car); //se nuestra por pantalla
				car = entrada.read(); //se lee el siguiente carácter del fichero
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
					
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}