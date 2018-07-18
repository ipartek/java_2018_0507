package com.ipartek.formacion.ejemplointerfaces;

public class PruebaInterfaces {

	public static void main(String[] args) {
		Rodable[] rodables = new Rodable[2];
		
		rodables[0] = new Naranja();
		rodables[1] = new Balon();
		
		for(Rodable r: rodables) {
			r.rodar();
			
			if(r instanceof Comestible) {
				((Comestible)r).comer();
			}
		}
	}

}
