package ejercicios.basicos.liniciales;

import java.io.IOException;
import java.util.Scanner;

public class BasicosEsturturaCondicional {
	
	public static void main(String[] args) {
		int Mes;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de mes:");
		Mes = sc.nextInt();
		if(Mes>=1 && Mes<=12) {
			switch(Mes) {
			case 1: System.out.print("Enero");
			break;
			case 2: System.out.print("Febrero");
			break;
			case 3: System.out.print("Marzo");
			break;
			case 4: System.out.print("Abril");
			break;
			case 5: System.out.print("Mayo");
			break;
			case 6: System.out.print("Junio");
			break;
			case 7: System.out.print("Julio");
			break;
			case 8: System.out.print("Agosto");
			break;
			case 9: System.out.print("Septiembre");
			break;
			case 10: System.out.println("Octubre");
			break;
			case 11: System.out.println("Noviembre");
			break;
			case 12: System.out.println("Diciembre");
			break;
			}
		}
		else {
			System.out.println("Mes incorrecto");
		}
		if(Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11) {     
            System.out.println(" es un mes de 30 días");
		}
        else if(Mes == 2) {
            System.out.println(" es un mes de 28 días");
        }
        else
            {System.out.println(" es un mes de 31 días");
        }
	}

	
	public static void main09(String[] args) {
		int H, M, S;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la hora:");
		H = sc.nextInt();
		System.out.println("Introduce el minuto:");
		M = sc.nextInt();
		System.out.println("Introduce el segundo:");
		S = sc.nextInt();
		
		if(H>=0 && H<=23 && M>=0 && M<=59 && S>=0 && S<=59) {
			System.out.println("La hora es: "+H+":"+M+":"+S);
		}
		else {
			System.out.println("Hora incorrecta");
		}
		
/*		if(H>=0 && H<=23) {
			if(M>=0 && M<=59) {
				if(S>=0 && S<=59) {
					System.out.println("La hora es: "+H+":"+M+":"+S);
				}
				else {
					System.out.println("Hora incorrecta");
				}
			}
			else {
				System.out.println("Hora incorrecta");
			}
		}
		else {
			System.out.println("Hora incorrecta");
		}
*/	}
	
	public static void main08(String[] args) {
		int n1, n2, n3;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer numero:");
		n1 = sc.nextInt();
		System.out.println("Introduce el segundo numero:");
		n2 = sc.nextInt();
		System.out.println("Introduce el tercer numero:");
		n3 = sc.nextInt();
		if(n1>n2 && n1>n3) {
			System.out.println(n1+" es el mayor");
		}
		else {
			if(n2>n3) {
				System.out.println(n2+" es el mayor");
			}
			else {
				System.out.println(n3+" es el mayor");
			}
		}
	}

	
	public static void main07(String[] args) {
		double n1, n2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el dividendo:");
		n1 = sc.nextInt();
		System.out.println("Introduce el divisor:");
		n2 = sc.nextInt();
		if(n2 != 0) {
			System.out.println(n1 + " / " + n2 + " = " +n1/n2);
		}
		else {
			System.out.println("No se puede dividir por 0");
		}
		}

	
	public static void main06(String[] args) throws IOException {
		char c1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un caracter:");
		c1 = (char)System.in.read();
		System.out.println(c1);
		if(Character.isDigit(c1)) {
			System.out.println("Es un numero");
		}
		else {
			System.out.println("Es un caracter");
		}
		if(c1 >='0' && c1 <='9') {
			System.out.println("Es un numero");
		}
		else {
			System.out.println("Es un caracter");
		}
	}

	
	public static void main05(String[] args) throws IOException {
		char c1, c2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer caracter:");
		c1 = (char)System.in.read();
		System.in.read(); 
		System.in.read(); 
		System.out.println("Introduce el segundo caracter:");
		c2 = (char)System.in.read();
		if (Character.isLowerCase(c1) && Character.isLowerCase(c2) ) {
			System.out.println("Los dos caracteres son minuscula");
		}
		else {
			System.out.println("Los dos caracteres no son minuscula");
		}
	}

	
	public static void main04(String[] args) throws IOException {
		
		char c1, c2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer caracter:");
		c1 = (char)System.in.read();
		System.in.read(); 
		System.in.read(); 
		System.out.println("Introduce el segundo caracter:");
		c2 = (char)System.in.read();
		if (c1==c2) {
			System.out.println("Los caracteres son iguales");
		}
		else {
			System.out.println("Los caracteres son distintos");
		}
	}

	
	public static void main03(String[] args) throws IOException {
		char c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un caracter:");
		c = (char)System.in.read();
		if(Character.isUpperCase(c)) {
			System.out.println("Es mayuscula");
		}
		else {
			System.out.println("Es minuscula");
		}
		
	}

	
	public static void main02(String[] args) {
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		numero = sc.nextInt();
		if(numero%10 == 0) {
			System.out.println("El numero "+numero+" es multiplo de 10");
		}
		else {
			System.out.println("El numero "+numero+" no es multiplo de 10");
		}
	}

	
	public static void main01(String[] args) {
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		numero = sc.nextInt();
		
		System.out.println(numero + (numero%2 == 0 ? " es par" : " es impar"));
		
/*		if(numero%2 == 0) {
			 System.out.println("El numero "+numero+" es par");
		 }
		 else {
			 System.out.println("El numero "+numero+" es impar");
		 }
*/		

	}

}
