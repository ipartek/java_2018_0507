package com.ipartek.formacion.operaciones;
public class Main {

	public static void main(String[] args) {
		System.out.println(Operaciones.esPrimo(5));
		System.out.println(Operaciones.esPrimo(4));
			
		System.out.println(Operaciones.factorial(5,true));
		
		Operaciones.fibonacci(20);
		
		Operaciones.mostrarDivisores(66);
		
		Operaciones.mostrarDivisores(200,true);
		
		Operaciones.mostrarPrimos(5,100);
		Operaciones.mostrarPrimos(100,5);
		
		
		System.out.println();
		System.out.println(Operaciones.potencia(3, 3));
		
	
	}

}
