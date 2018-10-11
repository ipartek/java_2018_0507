package com.ipartek.formacion.otrosEjemplos;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoogeryArray {
	
	 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//VECTOR
		@SuppressWarnings("rawtypes")
		Vector v=new Vector();
		v.add(1);
		v.add("HOLA");
		v.add(new java.util.Date());
		v.add(new Punto(1,2));
		
		
		for(int i=0;i< v.size();i++)
			System.out.println(v.elementAt(i));
		
		
		//Cojop la x q se encuentra en El objeto punto que se encuentra en el elemento3
		int x=((Punto)v.elementAt(3)).getX();
		
		System.out.print(x);
		
		
		//
		
		Punto p=(Punto)v.elementAt(3);
		System.out.println(p.getY());
		
		
		
	}

	public static void main1(String[] args) {
		//logger
		System.out.println("Hola");
		
		
		Logger l =Logger.getLogger(LoogeryArray.class.getName());
		l.info("Prueba de looger");
		l.log(Level.SEVERE,"prueba grave",new RuntimeException("Prueba de excepcion"));
		
		
		/*************/
		String snum="123";
		@SuppressWarnings("unused")
		int i=Integer.parseInt(snum);

	}

}
