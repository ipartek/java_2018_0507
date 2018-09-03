package a.webEjers.ejercicios.basico_2;

import java.util.Scanner;

public class Ejer_9_AreaTriangulo {
/*
Programa Java que calcule el área de un triángulo en función de las longitudes de sus lados (a,
b, c), según la siguiente fórmula:
Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
donde p = (a+b+c)/2
Para calcular la raíz cuadrada se utiliza el método Math.sqrt()
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b,c,p;
		
		System.out.print("Introduzca longitud del primer lado del triángulo: ");
		a = sc.nextDouble();
		System.out.print("Introduzca longitud del segundo lado del triángulo: ");
		b = sc.nextDouble();
		System.out.print("Introduzca longitud del tercer lado del triángulo: ");
		c = sc.nextDouble();
		p = (a+b+c)/2;
		System.out.println("Area -> " + Math.sqrt(p*(p-a)*(p-b)*(p-c)));
	
		sc.close();
	}

}
