package com.ipartek.formacion.ejemplointerfaces;

public class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Soy un balón rodando, lala laaaa");
	}

}
