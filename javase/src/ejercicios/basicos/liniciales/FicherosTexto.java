package ejercicios.basicos.liniciales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicherosTexto {
	
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("c:/ficheros/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			String cadena = entrada.readLine();
			while(cadena != null) {
				System.out.println(cadena);
				cadena = entrada.readLine();
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
		}
	}

	
/* Escribir al final del fichero.
 * 	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        try(FileWriter fw = new FileWriter("c:/ficheros/datos.txt", true)){
        	PrintWriter salida = new PrintWriter(fw);
        	System.out.println("Escribe un texto. Para terminas escribe FIN.");
        	cadena = sc.nextLine();
        	while(!cadena.equalsIgnoreCase("FIN")) {
        		salida.println(cadena);
        		cadena = sc.nextLine();
        	}
        } catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
 */

	/* ESCRIBIR EN ARCHIVO
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        try (PrintWriter salida = new PrintWriter("c:/ficheros/datos.txt")){
        	String cadena;
        	System.out.println("Introduce un texto. Para acabar introduce FIN.");
        	cadena = sc.nextLine();
        	while(!cadena.equalsIgnoreCase("FIN")) {
        		salida.println(cadena);
        		cadena = sc.nextLine();
        	}
        	salida.flush();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
	}
	*/

}
