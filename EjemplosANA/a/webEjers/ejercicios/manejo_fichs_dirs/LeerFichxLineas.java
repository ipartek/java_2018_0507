package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//Pag.139
public class LeerFichxLineas {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//fr = new FileReader("C:/Users/piscisroja/git/Ipartek/Ipartek/a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt");
			fr = new FileReader("a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt");
			
			BufferedReader entrada = new BufferedReader(fr);
			String cadena = entrada.readLine(); //se lee la primera línea del fichero/
			while (cadena != null) { //mientras no se llegue al final del fichero
				System.out.println(cadena); //se nuestra por pantalla
				cadena = entrada.readLine(); //se lee la siguiente línea del fichero
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
