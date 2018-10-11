package com.ipartek.formacion.otrosEjemplos;

public class EnumeracionEj {

	
	public enum Genero {MUJER,HOMBRE};
	
	
	public static void main(String[] args) {
		
		Genero miGenero;
		miGenero=Genero.HOMBRE;
		
		System.out.println(miGenero);
	}

}
