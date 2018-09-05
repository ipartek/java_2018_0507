package a.webEjers.ejercicios.basico_1_inicial;

public class Ejer_2 {
/*
 * Ejercicio básico inicial 2:
Escribe un programa Java que realice lo siguiente: declarar dos variables X e Y de tipo int,
dos variables N y M de tipo double y asigna a cada una un valor. A continuación muestra por
pantalla:
El valor de cada variable.
La suma X + Y
La diferencia X – Y
El producto X * Y
El cociente X / Y
El resto X % Y
La suma N + M
La diferencia N – M
El producto N * M
El cociente N / M
El resto N % M
La suma X + N
El cociente Y / M
El resto Y % M
El doble de cada variable
La suma de todas las variables
El producto de todas las variables
Si por ejemplo le hemos dado a X el valor 1, a Y el valor 2, a M el valor 3.2 y a N el valor 4.7
se debe mostrar por pantalla:
Variable X = 1
Variable Y = 2
Variable M = 3.2
Variable N = 4.7
1 + 2 = 3
1 - 2 = -1
1 * 2 = 2
1 / 2 = 0
1 % 2 = 1
4.7 + 3.2 = 7.9
4.7 - 3.2 = 1.5
4.7 * 3.2 = 15.040000000000001
4.7 / 3.2 = 1.46875
4.7 % 3.2 = 1.5
1 + 4.7 = 5.7
2 / 3.2 = 0.625
2 % 3.2 = 2.0
Variable X = 1 el doble es 2
Variable Y = 2 el doble es 4
Variable M = 3.2 el doble es 6.4
Variable N = 4.7 el doble es 9.4
1 + 2 + 4.7 + 3.2 = 10.9
1 * 2 * 4.7 * 3.2 = 30.080000000000002

 */
	public static void main(String[] args) {
		int x=1;
		int y=2;
		double n=4.7;
		double m=3.2;
		
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("m="+m);
		System.out.println("n="+n);
		
		System.out.println(x+"+"+y+"="+(x+y));
		System.out.println(x+"-"+y+"="+(x-y));
		System.out.println(x+"*"+y+"="+(x*y));
		System.out.println(x+"/"+y+"="+(x/y));
		System.out.println(x+"%"+y+"="+(x%y));
		System.out.println(n+"+"+m+"="+(n+m));
		System.out.println(n+"-"+m+"="+(n-m));
		System.out.println(n+"*"+m+"="+(n*m));
		System.out.println(n+"/"+m+"="+(n/m));
		System.out.println(n+"%"+m+"="+(n%m));
		System.out.println(x+"+"+n+"="+(x+n));
		System.out.println(y+"/"+m+"="+(y/m));
		System.out.println(y+"%"+m+"="+(y%m));
		System.out.println(x+"*"+2+"="+(x*2));
		System.out.println(y+"*"+2+"="+(y*2));
		System.out.println(n+"*"+2+"="+(n*2));
		System.out.println(m+"*"+2+"="+(m*2));
		System.out.println(x+"+"+y+"+"+n+"+"+m+"="+(x+y+n+m));
		System.out.println(x+"*"+y+"*"+n+"*"+m+"="+(x*y*n*m));
		
		
		

	}

}
