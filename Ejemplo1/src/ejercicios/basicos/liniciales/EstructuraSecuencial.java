package ejercicios.basicos.liniciales;

import java.util.Scanner;

public class EstructuraSecuencial {
	
	public static void main(String[] args) {
		
		double a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la longitud del primer lado del triángulo");
		a = sc.nextInt();
		System.out.println("Introduzca la longitud del segundo lado del triángulo");
		b = sc.nextInt();
		System.out.println("Introduzca la longitud del tercer lado del triángulo");
		c = sc.nextInt();
		
	}

	
	public static void main08(String[] args) {
		double radio, volumen;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la longitud del radio:");
		radio = sc.nextInt();
		volumen = (4.0/3)* Math.PI * Math.pow(radio, 3);
		System.out.println("Volumen de la esfera de radio: "+volumen);
		
	}

	
	public static void main07(String[] args) {
		double cateto1, cateto2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la longitud del primer cateto:");
		cateto1 = sc.nextInt();
		System.out.println("Introduce la longitud del segundo cateto:");
		cateto2 = sc.nextInt();
		double hipotenusa = Math.sqrt(Math.pow(cateto1,2) + Math.pow(cateto2,2));
		System.out.println("Hipotenusa = "+hipotenusa);
	}

	
	public static void main06(String[] args) {
		
		double kilometros, millas;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los kilometros por hora:");
		kilometros = sc.nextInt();
		System.out.println(kilometros+" km/h son "+kilometros*1000/3600+" m/h");
	}

	
	public static void main05(String[] args) {
		
		double radio, longitud, area;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce radio de la circunferencia:");
		radio = sc.nextInt();
		System.out.println("Radio introducido: "+radio);
		longitud = 2*Math.PI*radio;
		System.out.println("Longitud de la circunferencia = "+longitud);
		area = Math.PI*Math.pow(radio, 2);
		System.out.println("Area de la circunferencia = "+area);
		
	}

	
	public static void main04(String[] args) {
		double nC, nF;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce grados centigrados");
		nC = sc.nextInt();
		System.out.println(nC+"ºC = "+(nF =32 + ( 9 * nC / 5))+"ºF");
	}

	
	public static void main03(String[] args) {
		int n1 = 5;
		Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: "); 
        n1 = sc.nextInt();
        System.out.println("El numero introducido es "+n1);
        System.out.println("El dobre de "+n1+" es "+(n1*2));
        System.out.println("El triple de "+n1+" es "+(n1*3));
	}

	
	public static void main02(String[] args) {
		String nombre = "";
		Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre: "); 
        nombre = sc.nextLine();
        System.out.println("Buenos dias "+nombre);

	}


	public static void main01(String[] args) {

		//declaración de variables
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        //leer el primer número 
        System.out.println("Introduce un número entero: "); 
        n1 = sc.nextInt();      //lee un entero por teclado
        //leer el segundo número
        System.out.println("Introduce otro número entero: "); 
        n2 = sc.nextInt();      //lee un entero por teclado
        //mostrar resultado
        System.out.println("Ha introducido los números: " + n1 + " y " + n2);
		
	}

}
