package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejoFichero {

	public static void escribirFich(String movil) {
	BufferedWriter bw = null;
    FileWriter fw = null;

    try {
        File file = new File("datos.txt");
       
        if (!file.exists()) {
            file.createNewFile();
        }
     
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        
        bw.write(movil.toString());
        
        System.out.println("info guardada");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
                    
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
	}
	/*public static void escribirFich(String movil) {
			
	
		PrintWriter salida = null;
		try {
			salida = new PrintWriter("datos.txt");
			salida.println(movil.toString());
			salida.flush();
			
			System.out.println("Datos guardados en el fichero");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			salida.close();
	}
	}*/	
	
	public static void leerFich() {
		FileReader fr = null;
		try {
			fr = new FileReader("datos.txt");
			
			BufferedReader entrada = new BufferedReader(fr);
			String cadena = entrada.readLine();
			while (cadena != null) { 
				System.out.println(cadena);
				cadena = entrada.readLine();
			}
			entrada.close();
		} catch ( Exception e) {
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
