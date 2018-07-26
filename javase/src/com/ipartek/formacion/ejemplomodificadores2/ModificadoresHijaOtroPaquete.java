package com.ipartek.formacion.ejemplomodificadores2;

import com.ipartek.formacion.ejemplomodificadores.Modificadores;

public class ModificadoresHijaOtroPaquete extends Modificadores{
	public static void main(String[] args) {
		Modificadores m = new Modificadores();
		System.out.println(m.publico);
		//System.out.println(m.paquete);
		//System.out.println(m.protegido);
		//System.out.println(m.privado);
		
		ModificadoresHijaOtroPaquete m2 = new ModificadoresHijaOtroPaquete();
		m2.mostrarDato();
	}
	
	public void mostrarDato() {
		System.out.println(protegido);
	}
}
