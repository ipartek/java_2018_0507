package com.ipartek.formacion.operaciones;



public class Operaciones {
	
	public static boolean esPrimo(int numero){
		for(int i=2;i<numero;i++){
		    if(numero%i==0) 
		    	return false;
		}
		return true;
	}
	
	public static long factorial (int numero,boolean mostrar){
		
		long resultado = 1;
		
		for(int i=1;i<=numero;i++){
			if(mostrar && i<numero) {
				System.out.print(i+" x ");
			}else if(mostrar){
				System.out.print(i+" = ");
			}
			resultado=resultado*i;
		}
		return resultado;
	}
	
	public static void fibonacci(int numeroFactores)	{
		
		int n1=0;
		int n2=1;
		int res=0;
		
		System.out.print(n1+", "+n2+", ");
		
		for(int i=2;i<=numeroFactores;i++){
			res=n1+n2;
			n1=n2;
			n2=res;
			System.out.print(res+", ");
		}
		System.out.println("\n");
	}
	
	public static void mostrarDivisores(int numero){
		
		System.out.print("Los numeros divisores de "+ numero+" son: ");
		
		for (int i=1;i<=numero;i++){
			if(numero%i==0)
				System.out.print(i +",");
		}
		System.out.println("");
	}
	
	public static void mostrarDivisores(int numero,boolean primo){
			
		System.out.print("Los numeros divisores de "+ numero+" y que ademas son primos son: ");
		
		for (int i=1;i<=numero;i++){
			if(numero%i==0) {
				if (esPrimo(i)) {
					System.out.print(i +",");
				}
			}
		}
		System.out.println("");
	}
	
	
	public static void mostrarPrimos(int num1,int num2){
		if(num1<num2) {
			System.out.println("Los numeros primos entre "+ num1+" y "+num2 +" son:");
			for (int i=num1;i<=num2;i++){
				if(esPrimo(i)){				
					System.out.print(i +",");
				}	
				
			}
			System.out.println();
		}else {
			System.out.println("Los numeros primos entre "+ num1+" y "+num2 +" son:");
			for (int i=num1;i>num2;i--){
				if(esPrimo(i)){				
					System.out.print(i +",");
				}	
			}
			System.out.println();
		}
	}
	
	public static double potencia(int base, int potencia){
		double resultado=1;
		
		for(int i=0;i<potencia;i++)
			resultado=resultado*base;
		
		return resultado;
	}
	
	public static void mostrarDivisoresPrimos(int num)
	{
		int h=1;
		int a=0;
		for (int i=1;i<num;i++)
		{
			if(num%i==0)
			{				
				for(h=1;h<=num;h++)
				{
				    if(num%h==0) 
				    a++;
				}
				if(a==2)
					System.out.println(h + "es primo de " + num);
				
			}
				
		}
	}
}
