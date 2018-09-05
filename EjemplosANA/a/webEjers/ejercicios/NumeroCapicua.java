package a.webEjers.ejercicios;

import java.util.Scanner;

/*Comprobar SI UN NÚMERO ES CAPICÚA EN JAVA
Un número es capicúa si se puede leer igual de derecha a izquierda que de izquierda a
derecha. Ejemplos de números capicúas: 121, 3003, 1234321, 33, 445544, etc.
Vamos a escribir un programa Java que pida por teclado un número entero N de más de una
cifra y verifique si es capicúa.
import java.util.Scanner;
public class Numero_Capicua {
public static void main(String[] args) {
int N, aux, inverso = 0, cifra;
Scanner sc = new Scanner(System.in);
do {
System.out.print("Introduce un número >= 10: ");
public class NumeroCapicua {
*/

//Pagina 51
public class NumeroCapicua{
	public static void main(String args[]) {
		int num=1,aux,inverso=0,cifra;
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Introduce un numero>=10");
			num=sc.nextInt();
			System.out.println(num);
		}while(num<10);
		
		//le damos la vuelta al numero
		aux = num;
		while (aux!=0){
			cifra = aux % 10;
			inverso = inverso * 10 + cifra;
			aux = aux / 10;
		}
		if(num == inverso){
			System.out.println("Es capicua");
		}else{
			System.out.println("No es capicua");
		}
		sc.close();
	}
}
