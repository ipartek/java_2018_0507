package ejercicios.basicos.liniciales;

import java.util.Scanner;

public class buclesAnidados {
	
	public static void main(String[] args) {
		for(int a = 0; a<=9; a++) {
			for (int b = 0; b<=9; b++) {
				for(int c = 0; c<=9; c++) {
					for(int d = 0; d<=9; d++) {
						for(int e = 0; e<=9; e++) {
							System.out.print(a != 3 ? a : "E");
							System.out.print(b != 3 ? b : "E");
							System.out.print(c != 3 ? c : "E");
							System.out.print(d != 3 ? d : "E");
							System.out.print(e != 3 ? e : "E");
							System.out.println();
						}
					}
				}
			}
		}
	}

	
// EJERCICIO 4
	public static void main04(String[] args) {
		
		for (char x = 'Z'; x >= 'A'; x--) {
            for (char y = x; y >= 'A'; y--) {
                System.out.print(y);
            }
            System.out.println();
        }
	}
	
	//EJERCICIO 3	
	public static void main02(String[] args) {
		int n, j;
		double factorial, suma = 0;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce un numero:");
			n = sc.nextInt();
		}
		while(n<=0);
		
		for(int i = 0; i<=n; i++) {
			factorial = 1;
			for(j = 1; j<=i ; j++) {
				factorial = factorial * j;
			}
            System.out.printf("%2d! = %.0f %n", i, factorial);
            suma = suma + factorial;
		}
		System.out.println("Suma de todos los factoriales = "+suma);
		
	}

	
//EJERCICIO 2
	public static void main0111(String[] args) {
		int n;
		int j;
		double factorial;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce un numero:");
			n = sc.nextInt();
		}
		while(n<=0);
		
		for(int i = 0; i<=n; i++) {
			factorial = 1;
			for(j = 1; j<=i ; j++) {
				factorial = factorial * j;
			}
            System.out.printf("%2d! = %.0f %n", i, factorial);
		}
		
	}

//Ejercicio1	
	public static void main012(String[] args) {
		
		for (int n = 1; n<=1000; n++) {
			double suma = 0;
			for(int i = 1; i < n; i++ ) {
				
				if(n%i == 0) {
					suma = suma + i;
				}
			}
			if(suma == n) {
				System.out.println(n+" Es un numero perfecto");
			}
		}		
	}


	public static void main01(String[] args) {
		int n;
		double suma = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce un numero:");
			n = sc.nextInt();
		}
		while(n<=0);
		
		for(int i = 1; i < n; i++ ) {
			
			if(n%i == 0) {
				suma = suma + i;
			}
		}
		if(suma == n) {
			System.out.println(n+" Es un numero perfecto");
		}
		else {
			System.out.println(n+" no es un numero perfecto");
		}
	}

	

}
