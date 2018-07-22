package ejercicios.basicos.liniciales;

import java.util.Scanner;

public class EjerciciosBásicosArrays {
	
	public static void main(String[] args) {
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
