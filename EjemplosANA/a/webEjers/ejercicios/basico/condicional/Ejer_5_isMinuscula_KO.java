package a.webEjers.ejercicios.basico.condicional;

import java.io.IOException;
import java.util.Scanner;

public class Ejer_5_isMinuscula_KO {
/*5: Programa java que lea dos caracteres por teclado y compruebe si los dos son
letras minúsculas
*/
	
	
	//NO DEJA INTRODUCIR EL SEGUNDO CARACTER
	public static void main(String[] args) throws IOException {

			char car1, car2;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduzca primer carácter: ");
			car1 = (char)System.in.read(); //lee un carácter
			System.in.read(); //saltar el intro que ha quedado
			System.out.println("Introduzca segundo carácter: ");
			car2 = (char)System.in.read(); //lee el segundo carácter
			if(Character.isLowerCase(car1)){ 
	
				if(Character.isLowerCase(car2))
					System.out.println("Los dos son letras minúsculas");
				else
					System.out.println("El primero es una letra minúscula pero el segundo no");
			}else{
				if(Character.isLowerCase(car2))
					System.out.println("El segundo es una letra minúscula pero el primero no");
				else
						System.out.println("Ninguno es una letra minúscula");
			}
			
			
			
			if(car1>='a' && car1<='z'){
				if(car2>='a' && car2<='z')
					System.out.println("Los dos son letras minúsculas");
				else
					System.out.println("El primero es una letra minúscula pero el segundo no");
			}else{
				if(car2>='a' && car2<='z')
					System.out.println("El segundo es una letra minúscula pero el primero no");
				else
					System.out.println("Ninguno es una letra minúscula");
			}
			sc.close();
		
	}
/*
		
		String letra;
		String letra2;
		
		try {
			System.out.print("Introduce una letra (Mayuscula/Minuscula: ");
		//	letra = (char)System.in.read();//lee un solo caracter;
			Scanner sc = new Scanner(System.in);
			
			
			System.out.print("Introduzca primer carácter: ");
			letra =  sc.next();
			//System.in.read();//Saltar el enter
			System.out.print("Introduce segundo caracter: ");
			letra2 = sc.next();
			letra.toCharArray();
			
			if(letra[0]=='c');
			//Primera forma
			if(Character.isLowerCase(letra)) {
				if (Character.isLowerCase(letra2))
					System.out.println("Los dos son minusculas");
				else
					System.out.println("El primero es minuscula pero el segundo no");
			}else {
				if (Character.isLowerCase(letra2))
					System.out.println("El primero es mayuscula");
				else
					System.out.println("El primero es mayuscula pero el segundo no");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
}
