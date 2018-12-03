package com.ipartek.formacion.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import com.ipartek.formacion.MF0966_3.pojos.ConnectPersonasBD;

public class Main {
	//Tenemos un fichero con 10.000 personas que tenemos que migrar a nuestra base de datos, mediante un procedimiento hecho en java.  ( 4 puntos - UF2213 )
	public static void main(String[] args) {
		 String linea;
	      FileReader f;
	      String[] campos=new String[7];
		try {
			
		    StringTokenizer st;
			f = new FileReader("personas.txt");
			BufferedReader b = new BufferedReader(f);
			while((linea = b.readLine())!=null) {
				System.out.println( linea);
				st = new StringTokenizer (linea,",");
				
				int i=0;
				while (st.hasMoreTokens()){
					linea.split(",");
					linea = st.nextToken();
					System.out.println (" valor : " + linea);
					campos[i]=linea;
					i++;
				}
				
				
				//Llamar a la bd para la insert
				
				ConnectPersonasBD.anadirRegistro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
			}
		    b.close();
		     
		   
		} catch (Exception e) {
			
			System.out.println("Error al importar el archivo" + e.getMessage());
			e.printStackTrace();
		}
	      

	}

}
