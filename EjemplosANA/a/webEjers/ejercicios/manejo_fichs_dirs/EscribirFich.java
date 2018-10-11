package a.webEjers.ejercicios.manejo_fichs_dirs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirFich {
//Pag.135
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter salida = null;
		try /*(PrintWriter salida = new PrintWriter("c:/ficheros/datos.txt"))*///Escribiendo esta linea no es necesario cerrar el fichero en el finally, lo hace automaticamente
		{
			//salida = new PrintWriter("C:/Users/piscisroja/git/Ipartek/Ipartek/a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt"); //se crea el fichero
			salida = new PrintWriter("a/webEjers/ejercicios/manejo_fichs_dirs/datos.txt"); //se crea el fichero
			String cadena;
			System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
			cadena = sc.nextLine(); //se introduce por teclado una cadena de texto
			while (!cadena.equalsIgnoreCase("FIN")) {
				salida.println(cadena); //se escribe la cadena en el fichero
				cadena = sc.nextLine(); //se introduce por teclado una cadena de texto
			}
			salida.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			salida.close();
			sc.close();
		}
	}
	/*El método flush() provoca que se escriban en el fichero los datos que puedan haber en el
	buffer de salida.
	El método close() cierra la conexión con el fichero y libera los recursos que está usando la
	conexión.*/
}
