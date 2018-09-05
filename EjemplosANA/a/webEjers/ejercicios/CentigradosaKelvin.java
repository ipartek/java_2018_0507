package a.webEjers.ejercicios;

import java.util.*;
import java.io.*;

public class CentigradosaKelvin {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		double temperatura;
		char car;
	
		do{
			System.out.print("Introduce temperatura en ºC: ");
			temperatura = sc.nextDouble();
			System.out.println("KELVIN: " + (temperatura+273));
			
			System.out.print("Introducir otro (S/N): " );
			car = (char)System.in.read();
		}while(car =='S' || car == 's');
		sc.close();
	}

}
