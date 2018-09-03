package com.ipartek.formacion.pajaros;

import java.util.ArrayList;
import java.util.List;

public class Principal extends Ave {
	static int num_aves=0;
	
	
	public static void main(String[] args) {
		
		List <Piolin> piolines = new ArrayList<Piolin>();
		List <Loro> loro = new ArrayList<Loro>();
		
		loro.add(new Loro('h',16, 'E',"Rojo"));
		
		piolines.add(new Piolin('H', 3, 2,3));
		piolines.add(new Piolin('M', 1, 5,4));
		piolines.add(new Piolin('H', 4, 7,2));
		
		
		for (Loro l:loro)	
			Ave.cantar("Loro");
		
		for (Piolin p:piolines)	
			Ave.cantar("Piolin");

		

		Ave.mostrarNAves();
		Piolin pio=new Piolin('M', 15, 3,5);
		DatosPersonales.setNombreAve("Paquito");
		Loro l1=new Loro('F',3, 'N',"verde");
		
		pio.quienSoy();
		l1.quienSoy();
		
		Canario.altura(5);
		l1.deDondeEres();
		
		Canario.tamanio=50;
		Canario.altura(6);
		
		l1.region='S';
		l1.deDondeEres();
		
		piolines.get(1);
		System.out.println("Nombre piolin: "+Piolin.getNombre());
		
		System.out.println("NºAves creadas "+Ave.num_aves);
	}
}
