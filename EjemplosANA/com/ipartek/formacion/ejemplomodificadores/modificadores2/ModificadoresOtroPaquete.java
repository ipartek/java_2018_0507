package com.ipartek.formacion.ejemplomodificadores.modificadores2;

import com.ipartek.formacion.ejemplomodificadores.Modificadores;

public class ModificadoresOtroPaquete extends Modificadores{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Modificadores m=new Modificadores();
	//System.out.println(m.paquete);
	System.out.println(m.publico);
	//System.out.println(m.protegido);
	//System.out.println(m.privado);
	ModificadoresOtroPaquete m2=new ModificadoresOtroPaquete();
	m2.mostrarDato();

}
public void mostrarDato() {
	System.out.println(publico);
}

}
