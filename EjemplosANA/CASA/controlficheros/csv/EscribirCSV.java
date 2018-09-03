package CASA.controlficheros.csv;

import java.io.File;
import java.io.FileWriter;

import CASA.controlficheros.properties.LeerProperties;

public class EscribirCSV {
	public static void main(String args[]) {
		escribirFicheroCSV();
	}
	public static void escribirFicheroCSV() {
		final String NEXT_LINE = "\n";
		try {

			//File file = new File("D:\\eWorkSpace\\ControlDeFicheros\\src\\ficheros\\fichCreados\\ficheCSV.csv");
			String ficheroCSV=LeerProperties.LeerProp("RUTA_CSV");
	    	 
			
			//File file = new File("src/ficheros/fichCreados/ficheCSV.csv");
			File file = new File(ficheroCSV+"ficheCSV.csv");
			
			FileWriter fw = new FileWriter(file,true);
			if ( !file.exists()) {
				fw.append("Columna1").append(",");
				fw.append("Columna2").append(NEXT_LINE);
			}
			fw.append("valuer1");
			fw.append(",");
			fw.append("2");
			fw.append(NEXT_LINE);

			fw.append("ano,3\n");

			fw.flush();
			fw.close();
		} catch (Exception e) {
			// Error al crear el archivo, por ejemplo, el archivo 
			// está actualmente abierto.
			e.printStackTrace();
		}
		
		System.out.println("-->"+LeerProperties.LeerProp("RUTA_CSV"));
		
	}
}
