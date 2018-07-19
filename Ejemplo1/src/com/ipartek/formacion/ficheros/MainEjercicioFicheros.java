package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainEjercicioFicheros {

	/*
	 * 1. Leer lineas de texto por teclado y escribirlas en un fichero de texto.
	 * */
	public static void mainFichero1(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter salida = null;
		String cadena;
		String nombreFichero = "C:/Users/curso/Documents/ficheroPrueba.txt";
		
		try {
			// se crea el fichero
			salida = new PrintWriter(nombreFichero);
			
			System.out.print("Introduce todo el texto que quieras y para acabar escriba FIN: ");
			cadena = sc.nextLine(); 
			while (!cadena.equalsIgnoreCase("FIN")) {
				// se escribe la cadena en el fichero
				salida.println(cadena); 
				// se introduce por teclado una cadena de texto
				cadena = sc.nextLine(); 
			}
			salida.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			salida.close();
			sc.close();
		}
	}
	
	  
	/*
	 * 2. Leer lineas de texto por teclado y añadirlas al final de un fichero de texto.
	 * */
	public static void mainFichero2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        String nombreFichero = "C:/Users/curso/Documents/ficheroPrueba.txt";
        
        // Intenta abrir el fichero indicado, si no, lo crea.
        try (FileWriter fw = new FileWriter(nombreFichero, true);
                PrintWriter salida = new PrintWriter(fw)) {
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
        	sc.close();
        }
    }


	/*
	 * 3. Leer linea a linea el contenido de un fichero de texto y mostrarlo por pantalla.
	 * */
	public static void mainFichero3(String[] args) {
		FileReader fr = null;
		String nombreFichero = "C:/Users/curso/Documents/ficheroPrueba.txt";
		
        try {
            fr = new FileReader(nombreFichero);
            BufferedReader entrada = new BufferedReader(fr);
            String cadena = entrada.readLine(); 				//se lee la primera línea del fichero
            while (cadena != null) {  							//mientras no se llegue al final del fichero
            System.out.println(cadena); 						//se nuestra por pantalla
                cadena = entrada.readLine(); 					//se lee la siguiente línea del fichero
            }
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

	
	/*
	 * 5. Leer un fichero línea a línea utilizando la clase Scanner.
	 * */
	public static void mainFichero5(String[] args) {
		String nombreFichero = "C:/Users/curso/Documents/ficheroPrueba.txt";
        File f = new File(nombreFichero);
        String cadena;
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(f); 			//se crea un Scanner asociado al fichero
            while (entrada.hasNext()) { 		//mientras no se alcance el final del fichero
                cadena = entrada.nextLine(); 	//se lee una línea del fichero
                System.out.println(cadena); 	//se muestra por pantalla
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            entrada.close();
        }  
    }
	
}
