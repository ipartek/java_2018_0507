package ejercicios.basicos.liniciales;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CadenasCaracteres {
	
	public static int contarCaracteres(String cadena, char caracter) {
		int posicion, contador = 0;
		posicion = cadena.indexOf(caracter);
		while(posicion != -1) {
			contador++;
		posicion = cadena.indexOf(caracter, posicion +1);
		}
		return contador;
	}
	
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto;
        char caracter;
        int numeroC = 0;
        
        do {
        	System.out.println("Introduce un texto:");
            texto = sc.nextLine();
        }while (texto.isEmpty());
        
        System.out.println("Introduce un caracter:");
        caracter = (char)System.in.read();
        
        numeroC = contarCaracteres(texto, caracter);
        System.out.println("El caracter "+caracter+" aparece "+numeroC+" veces.");
	}


/*	EJERCICIO 2
	public static String eliminarUltimaPalabra(String s) {
	    int pos;
	    s = s.trim();
	    pos = s.lastIndexOf(" ");
	    if (pos != -1) {
	         s = s.substring(0, pos);
	    } else {
	         s = "";
	    }
	    return s;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String texto;
	    do {
	       System.out.println("Introduce texto: ");
	       texto = sc.nextLine();
	     } while (texto.isEmpty());
	     texto = eliminarUltimaPalabra(texto);
	     System.out.println(texto);
	}
*/
	
	
	/*	EJERCICIO 1
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      String frase;
	      System.out.println("Escribe una frase:");
	      frase = sc.nextLine();
	      StringTokenizer st = new StringTokenizer(frase);
	      System.out.println("Número de palabras: " + st.countTokens());
	}
*/
}
