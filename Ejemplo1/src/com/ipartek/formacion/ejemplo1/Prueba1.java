package com.ipartek.formacion.ejemplo1;

public class Prueba1 {

	public static void main(String[] args) {
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
	}

}










