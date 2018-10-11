package a.webEjers.ejercicios.basico.condicional;

import java.io.IOException;
import java.util.Scanner;

public class Ejer_6_isDigito {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char car;
		System.out.println("Introduzca un carácter(letra/numero): ");
		car = (char)System.in.read(); //lee un carácter
		
		if(Character.isDigit(car))
			System.out.println("Es un numero");
		else
			System.out.println("Es una letra");
		
		//Versión alternativa comparando con
		// los caracteres '0' ... '9'
		if(car>='0' && car<='9')
			System.out.println("Es un número");
		else
			System.out.println("No es un número");
		
		sc.close();
	}

}
