package ejercicios.basicos.liniciales;

import java.io.IOException;
import java.util.Scanner;

public class EjerciciosGenerales {
	
	public static void main(String[] args) {
		int n1, n2;
		int suma1 = 0; 
		int suma2 = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer numero:");
		n1 = sc.nextInt();
		System.out.println("Introduce el segundo numero:");
		n2 = sc.nextInt();
		
		for (int contador = 1; contador<n1; contador++) {
			if(n1%contador==0) {
				suma1 = suma1+contador;
			}
		}
		for (int contador = 1; contador<n2; contador++) {
			if(n2%contador==0) {
				suma2 = suma2+contador;
			}
		}
		if(suma1==n2 && suma2==n1) {
			System.out.println("Los numeros "+n1+" y "+n2+" son amigos");
		}
		else {
			System.out.println("Los numeros "+n1+" y "+n2+" no son amigos");
		}
	}

	
	public static void main062(String[] args) {
		int numero;
		int contador;
		int suma = 0;
		for(numero = 1; numero<=1000; numero++) {
			suma = 0;
			for (contador = 1 ; contador<=numero; contador++) {
				if(numero%contador==0) {
					suma = suma+contador;
					if(suma == numero) {
						System.out.println(numero);
					}
				}
			}
		}
		

	}

	
	public static void main061(String[] args) {
		int n, contador;
		int suma = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		n = sc.nextInt();
		for (contador = 1 ; contador<n; contador++) {
			if(n%contador==0) {
				suma = suma+contador;
			}
		}
		if(suma == n) {
			System.out.println("El numero "+n+" es un numero perfecto");
		}
		else {
			System.out.println("El numero "+n+" no es un numero perfecto");
		}
	}

	
	public static void main05(String[] args) {
		int n;
		int contador = 0;
		do {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero:");
			n = sc.nextInt();
			if(n%10==2) {
				contador++;
			}	
		}
		while(n>=0);
		System.out.println("Se han leido "+contador+" numero/s terminado/s en 2.");

	}

	
	public static void main04(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		n = sc.nextInt();
		System.out.println("Tabla del "+n);
		System.out.println("------------");
		for(int contador = 1; contador<=10; contador++) {
			System.out.println(n+" x "+contador+" = "+(n*contador));
		}
		
	}

	
	public static void main03(String[] args) throws IOException {
		double gradosC;
		char continuar;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce ºC:");
			gradosC = sc.nextInt();
			System.out.println(gradosC+"ºC son "+(gradosC+273)+"ºK");
			System.out.println("Repetir proceso? (S/N)");
			continuar = (char)System.in.read();
		}
		while(continuar !='n' || continuar !='N' );
	}

	
	public static void main02(String[] args) throws IOException {
		
		int numero;
		int contador = 0;
		char continuar;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero:");
			numero = sc.nextInt();
			while (numero > 0) {
				numero = numero/10;
				contador++;
			}
			System.out.println("El numero tiene "+contador+" cifras");
			contador = 0;
			System.out.println("Continuar? (S/N)");
			continuar = (char)System.in.read();
		}
		while (continuar == 's' && continuar == 'S');
	
	}
	

	
	public static void main01(String[] args) {

	int A, B, aux;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduce un numero:");
	A = sc.nextInt();
	System.out.println("Introduce otro numero:");
	B = sc.nextInt();

	
	System.out.println("Valor de A = "+A);
	System.out.println("Valor de B = "+B);
	
	aux = A;
	A = B;
	B = aux;
	System.out.println("Nuevo valor de A = "+A);
	System.out.println("Nuevo valor de B = "+B);
	}
}
