package com.ipartek.formacion.ejemplomodificadores;

public class Modificadores {
	
	public String publico="publico";
	String paquete="paquete";
	protected String protegido="protegido";
	private String privado="privado";
	
	public static void Main (String[] args)
	{
		Modificadores m=new Modificadores();
		System.out.println(m.publico);
		System.out.println(m.paquete);
		System.out.println(m.protegido);
		System.out.println(m.privado);
	}
}
