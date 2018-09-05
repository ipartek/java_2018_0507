package com.ipartek.formacion.fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {

	private static final String RUTA_FICHERO = "fichero.txt";
	private static final boolean AUTO_FLUSH = true;
	private static final boolean SOBREESCRIBIR = false;
	public final static int TAM_ARRAY = 10;

	public enum Genero {
		MUJER, HOMBRE
		
		
		
	}; 

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(RUTA_FICHERO, SOBREESCRIBIR);
		PrintWriter pw = new PrintWriter(fw,AUTO_FLUSH);
		
		pw.println("Hola dsd Java");
		pw.println("Segunda línea");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(RUTA_FICHERO);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		while( (linea = br.readLine()) != null ) {
			System.out.println(linea);
		}
		
		br.close();
		fr.close();
	}
	

}
