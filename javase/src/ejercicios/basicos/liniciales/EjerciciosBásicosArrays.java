package ejercicios.basicos.liniciales;

import java.util.Scanner;

public class EjerciciosBásicosArrays {
	
	public static void main(String[] args) {
		//EJERCICIO 6
		double[] numeros = new double[10];
		int pos = 0, neg = 0;
		int sumaPos = 0, sumaNeg = 0;
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<numeros.length; i++) {
			System.out.println("introduce el valos de la posicion "+(i+1));
			numeros[i] = sc.nextInt();
			if(numeros[i]>0) {
				pos += 1;
				sumaPos += numeros[i];
			}
			else if(numeros[i]<0) {
				neg += 1;
				sumaNeg += numeros[i];
			}
		}
		System.out.println("Media de los valores positivos: "+sumaPos/pos);
		System.out.println("Media de los valores negativos: "+sumaNeg/neg);
		
		
	}
	
	//EJERCICIO 5
	public static void main05(String[] args) {
		
		int[] numeros = new int[10];
		int pos = 0, neg = 0, cero = 0;
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<numeros.length; i++) {
			System.out.println("introduce el numero "+(i+1));
			numeros[i] = sc.nextInt();
			if (numeros[i]>0) {
				pos += 1;
			}
			else if(numeros[i]<0) {
				neg += 1;
			}
			else if(numeros[i] == 0) {
				cero += 1;
			}
		}
		System.out.println("Numeros >0 = "+pos);
		System.out.println("Numeros <0 =  "+neg);
		System.out.println("Numeros = 0 = "+cero);		
	}
	
	//EJERCICIO 4
	public static void main04(String[] args) {
		int par = 2;
		int[] pares = new int[20];
		
		for(int i = 0; i<pares.length; i++) {
			pares[i] = par;
			par = par+2;
		}
		for(int i = 0; i<pares.length; i++) {
			System.out.println(pares[i]);
		}
	
	}
	
	//EJERCICIO 3
	public static void main03(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		double suma = 0;
		
		System.out.println("Introduce el numero de alumnos de clase");
		n = sc.nextInt();
		double[] alumnos = new double[n];
		for(int i=0; i<n; i++) {
			System.out.println("Introduce la nota del alumno "+(i+1));
			alumnos[i] = sc.nextInt();
		}
		
		for(int i = 0; i<alumnos.length; i++) {
			suma = suma + alumnos[i];
		}
		
		for(int i = 0; i<alumnos.length; i++) {
			if(alumnos[i]>suma/n) {
				System.out.println("El alumno "+(i+1)+" con nota "+alumnos[i]+" tiene una nota mayor que la media");
			}
		}
		System.out.println("Nota media de los alumnos = "+suma/n);
	
	}
	//EJERCICIO 2
	public static void main02(String[] args) {
	
		int[] numeros = new int[10];
		double suma = 0;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<10;i++) {
			System.out.println("Introduce un numero:");
			numeros[i] = sc.nextInt();
		}
		for(int i = 0; i<numeros.length; i++) {
			if(i%2 == 0) {
				suma = suma + numeros[i];
			}
		}
		System.out.println("la suma de las posiciones pares del array es: "+suma);
		System.out.println("La media de los numeros en las posiciones pares del array es: "+suma/5);
	}
	//EJERCICIO 1
	public static void main01(String[] args) {
		int pos = 0, neg = 0;
		double sumaPos = 0, sumaNeg = 0;
		int[] numeros = new int[10];
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i<10; i++) {
			System.out.println("Introduce un numero:");
			numeros[i] = sc.nextInt();
		}
		for (int i = 0; i<10; i++) {
			if(numeros[i]>0) {
				sumaPos += numeros[i];
				pos++;
			}
			else if(numeros[i]<0) {
				sumaNeg += numeros[i];
				neg++;
			}
		
		}
		if (pos != 0) {
            System.out.println("Media de los valores positivos: " + sumaPos / pos);
        } else {
            System.out.println("No ha introducido numeros positivos");
        }
        if (neg != 0) {
            System.out.println("Media de los valores negativos: " + sumaNeg / neg);
        } else {
            System.out.println("No ha introducido numeros negativos");
        }
		
		
/*		for(int e = 0; e <= numeros.length-1; e++) {
			System.out.println("posicion de array "+e+" "+numeros[e]);
		}
*/	}

}
