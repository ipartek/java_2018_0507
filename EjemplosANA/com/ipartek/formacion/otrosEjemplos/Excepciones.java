package com.ipartek.formacion.otrosEjemplos;

public class Excepciones {
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int div,a,b;
		a=5;b=0;div=0;
		
		try {
			Punto p;
			p=null;
			try {
				p = new Punto(500000000,10000);
			} catch (PuntoException e) {
				System.out.println("AKIxs :"+e.getMessage());
				p=new Punto(Punto.MAX_X,Punto.MAX_Y);
			}
			
			@SuppressWarnings("unused")
			int[] array=new int[2];
			//array[2]=5;
			
			//b=1;
			//div = a / b;
			System.out.println(p);
			
			
			//String s=null;
			//s.toUpperCase();
			
			System.out.println(div);
			
		} catch (ArithmeticException e) {
			System.out.println("Error:Division entre 0  " + e.getMessage());
			div=Integer.MAX_VALUE;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error:Array " + e.getMessage());
			return;
		}catch (Exception e){
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("FIN");
		}	
	}
}
