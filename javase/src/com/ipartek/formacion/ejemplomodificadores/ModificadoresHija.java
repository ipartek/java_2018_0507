package com.ipartek.formacion.ejemplomodificadores;

public class ModificadoresHija extends Modificadores {
	public static void main(String[] args) {
		Modificadores m = new Modificadores();
		System.out.println(m.publico);
		System.out.println(m.paquete);
		System.out.println(m.protegido);
		//System.out.println(m.privado);
	}
}
