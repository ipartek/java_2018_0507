package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        
        System.out.println("info guardada en el fichero");
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
