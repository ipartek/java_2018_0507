package com.ipartek.formacion.editorialrestspring.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static Properties leerPropiedades(String filename) {
		try {
			
			InputStream input = Utils.class.getClassLoader().getResourceAsStream(filename);
			
			if(input==null){
				throw new BibliotecaException("No se ha podido leer el fichero " + filename);
			}

			//load a properties file from class path, inside static method
			Properties prop = new Properties();
			
			prop.load(input);

			return prop;
		} catch (IOException e) {
			throw new BibliotecaException("No se ha podido leer el fichero", e);
		}
	}
}