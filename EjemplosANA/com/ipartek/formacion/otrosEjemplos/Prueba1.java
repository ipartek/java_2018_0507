package com.ipartek.formacion.otrosEjemplos;

public class Prueba1 {

	public static final int TAM_ARRAY = 10;
	

	@SuppressWarnings("unused")
	public static void main (String[] args) {
		Number nEjemplo=new Float(3.4);
		Number[] numeros =new Number[2];
		
		numeros[0]=new Integer(5);
		numeros[1]=new Double(6.7);
		for (Number n:numeros)
			System.out.println(n.doubleValue());
	}
	
	
	
	
	
	 
	public static void main4(String[] args) {
		ArrayAjedrez();
		main3(args);
		main2(args);
	}
	
	
	public static void ArrayAjedrez() {
		
		char[][] tablero=new char[8][8];
		
		tablero[0]= new char[] {'T','C','A','R','r','A','C','T'};
		tablero[7]=tablero[0].clone();
		
		for (int fila=1;fila<=6;fila+=5) {
			for(int columna=0;columna<8;columna++) {
				tablero[fila][columna]='p';
			}
		}
		
		for (int fila=0;fila<8;fila++) {
			for(int columna=0;columna<8;columna++) {
				System.out.print(tablero[fila][columna]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("**************************************");
		System.out.println();
		System.out.println();
	}
		
	
	public static void main3(String[] args) {

			System.out.println(Math.sqrt(4));
			
			int [] arr=new int[2];
			arr[0]=5;
			arr[1]=2;
			
			int[] arr2= {6,8};
			
			System.out.println(arr2[0]);
			
			String[] diasseman= {"Lunes","Martes"};
			
			System.out.println(diasseman[1]);
			
			Punto[] puntos=new Punto[TAM_ARRAY];
			puntos[0] = new Punto(1,2);
			
			Punto[] puntosPorDefecto = {new Punto(1),new Punto(2)};
			
			System.out.println("----"+puntosPorDefecto[1]);
			System.out.println(puntosPorDefecto[1].getX());
			
			
			
			
			for(Punto p: puntosPorDefecto) {
				System.out.println(p);
			}
			
			
			
			Punto p;
			for (int i=0;i<puntosPorDefecto.length;i++) {
				p=puntosPorDefecto[i];
				System.out.println(p);
			}
			
			for (int i=0;i<puntos.length;i++) {
				puntos[i]=new Punto(i);
			}
			
			
			System.out.println();
			for(Punto p1: puntos) {
				System.out.println(p1);
			}
			
			System.out.println();
			System.out.println("**************************************");
			System.out.println();
			System.out.println();
	}
	
	
	public static void main2(String[] args) {
		System.out.println("BIENVENIDOS A GIT");
		//int[] arr = new int[2];
		
		//arr[2] = 5;

		Punto p = new Punto(3,4);
		
		Punto pt2 = (Punto) p.clone();
		
		p.setX(100);
		
		System.out.println(p.equals(pt2));
		
		System.out.println(p); //.hashCode());
		System.out.println(pt2); //.hashCode());
		
		Object o = p;
		
		//System.out.println(o.getX());
		
		Punto pt1 = (Punto) o;
		
		System.out.println(pt1);
		
		int i = 5;
		
		Object o2 = i;//new Integer(i);
		System.out.println(o2);
		System.out.println("Fin");
		
		
		
		System.out.println();
		System.out.println("**************************************");
		System.out.println();
		System.out.println();
	}

}

