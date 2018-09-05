package a.webEjers.ejercicios;
import java.util.*;

public class CocienteDosNumeros {

	/*
	
	Ejemplos de recursividad. Calcular el cociente de dos números enteros.
	Programa Java que calcule el cociente de dos números enteros de forma recursiva.
	La solución recursiva del problema se plantea de la siguiente forma:
	Caso Base: Si el dividendo es menor que el divisor el cociente es cero.
	Si no, se restan el dividendo y el divisor. Al resultado se le vuelve a restar el divisor. Esta
	resta se repite mientras se pueda realizar, o sea, mientras el resultado sea mayor o igual que el
	divisor.
	El número de veces que se ha hecho la resta es el cociente.
	Con un ejemplo lo veremos más claro. Por ejemplo, para dividir 10 entre 3 haríamos:
	10 - 3 = 7
	7 - 3 = 4
	4 - 3 = 1
	No se puede seguir restando ya que el último valor obtenido (1) es menor que el divisor.
	Como se han realizado 3 restas el cociente es 3.
	*/
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		System.out.print("Introduzca dividendo: ");
		n1 = sc.nextInt();
		
		do {
			System.out.print("Introduzca divisor (>0): ");
			n2 = sc.nextInt();
		} while (n1 <= 0);
		System.out.printf("%d/%d = %d %n", n1, n2, cociente(n1, n2));
		
		sc.close();
	}
	
	public static int cociente(int a, int b) {
		if (a < b)
			return 0;
		else
			return 1 + cociente(a - b, b);
	}
}