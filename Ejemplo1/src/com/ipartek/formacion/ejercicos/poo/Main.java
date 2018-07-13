package com.ipartek.formacion.ejercicos.poo;


public class Main {

	public static void main(String[] args) {
		
//		Piolin p = new Piolin ("Hembra",4,25,6);
//		p.QuienSoy();
//		p.Altura(p.tamano);
//		
//		Aves a = new Aves("Macho",3);
//		a.QuienSoy();
//		
//		Canario c = new Canario("Macho",23,34);
//		c.Altura(c.tamano);
//		
//		Loro l = new Loro("Hembra",21,'E',"verde");
//		l.DondeEres(l.getRegion());
//		
//		l.setRegion('S');
//		l.DondeEres(l.getRegion());
		
		
		Piolin[] piolines = new Piolin[2];
		
		
		piolines[0].setSexo("Hembra");
		piolines[0].setEdad(23);
		piolines[0].setTamano(24);
		piolines[0].setNumPeliculas(3);
		
		for (int i = 0; i < piolines.length; i++) {
			System.out.println(piolines[i].getSexo());
		}
		
		
		
		
		
		
		
		
	
		
		
	
		
		
		
		
		
	}

}
