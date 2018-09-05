package com.ipartek.formacion.ejemplomodificadores.modificadores2;

import com.ipartek.formacion.ejemplomodificadores.Modificadores;

public class Modificadores2 {
	
	public String publico="public";
	String paquete="(paquete)";
	protected String protegido="protected";
	private String privado="private";

	public static void main(String[] args) {
		Modificadores m=new Modificadores();
		//System.out.println(m.paquete);
		System.out.println(m.publico);
		//System.out.println(m.protegido);
	//	System.out.println(m.privado);

	}

}
