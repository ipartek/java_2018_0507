/*
 * Clase desde la que se llama a los metodos de lectura del teclado.
 */
package com.ipartek.prestamolibros.presentacionlibros;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerTeclado {
	public boolean reEjecutar= true;
	public Scanner sc = new Scanner(System.in);
	
	public LeerTeclado(Scanner sc) {
		super();
		this.sc = sc;
	}

	public long leerLong(long l) {
		return 	l = sc.nextLong();
	}
	
	public int leerInt(int i) {
		return i = sc.nextInt();

		//llamar a un booleano (externo) y recorrer un loop
		/*while(reEjecutar){
			try {
				return i = sc.nextInt();
			} catch (InputMismatchException ime) {
				reEjecutar=false;
				System.out.println("Vuelva a introducir los valores");
				Ejercicio1 e1 = new Ejercicio1();
				e1.leerNumero();
				return i = 0;
			}
		}
		return i;*/
		
	}
	public String leerString(String s) {
		return s = sc.nextLine();
	}	
	public String leerChar(String l) {
		return l = sc.nextLine();
	}
	public Double leerDoble(Double d) {
		return d= sc.nextDouble();
	}
}
