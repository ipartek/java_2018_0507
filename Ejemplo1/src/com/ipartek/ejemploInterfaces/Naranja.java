package com.ipartek.ejemploInterfaces;

public class Naranja extends Fruto implements Rodable,Comestible{

	@Override
	public void comer() {
		// TODO Auto-generated method stub
		System.out.println("la narnjaaaaaaa");
	}

	@Override
	public void rodar() {
		// TODO Auto-generated method stub
		System.out.println("soy una naranja rodando");
	}

}
