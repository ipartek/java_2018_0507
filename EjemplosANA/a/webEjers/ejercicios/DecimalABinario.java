package a.webEjers.ejercicios;

import java.util.Scanner;

public class DecimalABinario {
/*
	En esta entrada vamos a escribir el programa java para convertir un número de decimal a
	binario.
	Para escribir el programa nos vamos a basar en la forma clásica de pasar de decimal a binario,
	o sea, dividir el número entre 2 y quedarnos con el resto de la división. Esta cifra, que será un
	cero o un uno, es el dígito de menos peso (más a la derecha) del número binario. A
	continuación volvemos a dividir el cociente que hemos obtenido entre 2 y nos quedamos con
	el resto de la división. Esta cifra será la segunda por la derecha del número binario. Esta
	operación se repite hasta que obtengamos un cero como cociente.
	De forma gráfica lo vamos a ver mucho más claro:
	Si queremo convertir el número 12 en binario haremos las siguientes operaciones:
	El número 12 en decimal es el 1100 en binario. El número binario se obtiene tomando los
	restos en orden inverso a como se han obtenido.
	Los que ya sabéis algo de Java podeis pensar que para qué quiero hacer ese programa si
	simplemente escribiendo la instrucción:
	System.out.println(Integer.toBinaryString(numero));
	se mostrará el número en binario.
	El método toBinaryString de la clase Integer ya me hace el trabajo, pero se trata de que
	seamos capaces de desarrollar por nosotros mismos el algoritmo que realiza la conversión de
	decimal a binario.
	Este ejercicio se suele plantear cuando se está comenzando a aprender las estructuras
	repetitivas (while, for, do while) y aún no se conocen los arrays por lo que la solución que se
	plantea no utiliza arrays y por tanto esta solución aunque es correcta solo es válida para
	números enteros relativamente pequeños.*/


	public static void main(String[] args) {
		int numero, exp, digito;
		double binario;
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Introduce un numero entero >= 0: ");
			numero = sc.nextInt();
		}while(numero<0);
		
		exp=0;
		binario=0;
		while(numero!=0){
			digito = numero % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp++;
			numero = numero/2;
		}
		System.out.printf("Binario: %.0f %n", binario);
		sc.close();
	}
}
