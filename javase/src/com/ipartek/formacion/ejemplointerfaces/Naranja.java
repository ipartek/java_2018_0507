package com.ipartek.formacion.ejemplointerfaces;

public class Naranja extends Fruto implements Rodable, Comestible {

	@Override
	public void comer() {
		System.out.println("Mmmmmm, que rica la naranja");
	}

	@Override
	public void rodar() {
		System.out.println("Soy una naranja rodando, que se fastidie el balón");
	}

}
