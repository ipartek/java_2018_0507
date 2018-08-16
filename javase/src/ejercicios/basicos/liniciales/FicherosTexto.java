package ejercicios.basicos.liniciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class FicherosTexto {
	
	public static void main(String[] args) {
		Scanner entrada = null;
		String cadena, mayor = null, menor = null;
		JFileChooser j = new JFileChooser();
		j.showOpenDialog(j);
		try {
			String ruta = j.getSelectedFile().getAbsolutePath();
			File f = new File(ruta);
			entrada = new Scanner(f);
			if(entrada.hasNext()){
				cadena = entrada.nextLine();
				mayor = menor = cadena;
			}
			while(entrada.hasNext()) {
				cadena = entrada.nextLine();
				if(cadena.length() > mayor.length()) {
					mayor = cadena;
				}else if (cadena.length() < menor.length()) {
					menor = cadena;
				}
			}
			if(mayor == null || menor == null) {
				System.out.println("Fichero vacio");
			}else {
				System.out.println("Linea mas larga:");
				System.out.println(mayor);
				System.out.println("Linea mas corta");
				System.out.println(menor);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	
/*	Leer fichero con StringTokenizer
	public static void main(String[] args) {
		File f = new File("c:/ficheros/enteros.txt");
		int numero, suma = 0, cont = 0;
		StringTokenizer st;
		String cadena;
		Scanner entrada = null;
		try {
		entrada = new Scanner(f);
		while(entrada.hasNext()) {
			cadena = entrada.nextLine();
			st = new StringTokenizer(cadena, " ,");
			while(st.hasMoreTokens()) {
				numero = Integer.parseInt(st.nextToken());
				System.out.println(numero);
				suma = suma + numero;
				cont++;
			}
		}
		System.out.println("Numeros leidos: "+cont);
		System.out.println("Suma "+suma);
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			entrada.close();
		}
	}
*/
	
/*	Lectura por escaner
	public static void main(String[] args) {
		File f = new File("c:/ficheros/enteros.txt");
		int numero, suma = 0, cont = 0;
		Scanner entrada = null;
		try {
			entrada = new Scanner(f);
			while(entrada.hasNextInt()) {
				numero = entrada.nextInt();
				System.out.println(numero);
				suma = suma + numero;
				cont++;
			}
			System.out.println("Numeros leidos: "+cont);
			System.out.println("Suma: "+suma);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			entrada.close();
		}
	}
*/	

/*Leer ficheros
 * 
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
*/
	
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
