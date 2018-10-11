package com.ipartek.formacion.primerProg.principal;

import java.util.Date;
import com.ipartek.formacion.primerProg.personas.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		Persona p=new Persona(null, null, null, null, null);
		p.saludar();
		p.andar(20);
		
		System.out.println("Paga padre "+p.darPaga()+"\n");
		
		
		Persona a =new Persona("nombre","apellidos",123,new Date(),"12345678901234567890");
		Persona a1 =new Persona("nombre1","apellidos",123,new Date(),"12345678901234567890");
		Persona a2 =new Persona("nombre2","apellidos",123,new Date(),"12345678901234567890");
		Persona a3 =new Persona("nombre3","apellidos",123,new Date(),"12345678901234567890");
		Persona a4 =new Persona("nombre4","apellidos",123,new Date(),"12345678901234567890");
		Persona a5 =new Persona("nombre5","apellidos",123,new Date(),"12345678901234567890");
		
		
		//System.out.println(a.notaMedia+"\n");
		System.out.println("Paga alumno "+a.darPaga());
		
		
		
		p.setNumeroCuenta("12345678901234567890");
		
		System.out.println(p.getNumeroCuenta());

	}

}
