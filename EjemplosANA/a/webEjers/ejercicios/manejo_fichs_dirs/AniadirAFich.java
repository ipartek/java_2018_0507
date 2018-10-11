package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//135
public class AniadirAFich {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena;
		//try (FileWriter fw = new FileWriter("C:/Users/piscisroja/git/Ipartek/Ipartek/a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt", true); //Con el true se añade contenido
		try (FileWriter fw = new FileWriter("a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt", true); //Con el true se añade contenido
			PrintWriter salida = new PrintWriter(fw)) {
			System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
			cadena = sc.nextLine();
			while (!cadena.equalsIgnoreCase("FIN")) {
				salida.println(cadena);
				cadena = sc.nextLine();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		sc.close();
	}
}
