package a.webEjers.ejercicios;

public class Contador5Digitos {
/*
 * Programa Java que muestre todos los valores de un contador de 5 dígitos empezando por
00000 y acabando en 99999 con la particularidad que cada vez que se deba mostrar un 3 se
muestre E.
Solución: para resolverlo anidamos 5 bucles for, uno para dígito del contador.
 */
	public static void main(String[] args) {
		int a,b,c,d=0;
		for (a=0;a<10 ;a++) {
			for (b=0;b<10 ;b++) {
				for (c=0;c<10 ;c++) {
					for (d=0;d<10 ;d++) {
						for (int e=0;e<10 ;e++) {
							System.out.print(a != 3 ? a : "E");
							System.out.print(b != 3 ? b : "E");
							System.out.print(c != 3 ? c : "E");
							System.out.print(d != 3 ? d : "E");
							System.out.println(e != 3 ? e : "E");
						}
					}
				}
			}
		}

	}

}
