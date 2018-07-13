package com.ipartek.formacion.ejercicios.POO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Piolin p = new Piolin('H', 4,25, 6);
		Loro l = new Loro('M', 2, 'N', "Rojo");
		Loro l2 = new Loro('M', 2, 'N', "Rojo");
		
		System.out.println(Ave.numPajaros);
		/*
		System.out.println(l.numPajaros);
		l.numPajaros++;
		System.out.println(l2.numPajaros);
		*/
		
		l.quienSoy();
		p.quienSoy();
		
		p.altura();
		
		p.tamanio = 50;
		l.region = 'S';
		
		l.deDondeEres();
	}

}
