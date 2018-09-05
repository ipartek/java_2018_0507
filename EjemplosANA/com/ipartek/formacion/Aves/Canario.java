package com.ipartek.formacion.Aves;

public class Canario extends Ave{
	char sexo;
	int edad;
	public static Integer tamanio;// el tamaño (real).
	
	
	public Canario(char sexo,Integer edad) {
		super(sexo,edad);
	}
	@SuppressWarnings("static-access")
	public Canario(char sexo,int edad,Integer tamanio, int altura) {
		super(sexo,edad);
		this.tamanio=tamanio;
	}
	
	public static void altura(int tamanio) {
		
		if (tamanio != 0) {
			if (tamanio > 30) {
				System.out.println("Canario Alto");
			}else if(tamanio<15) {
				System.out.println("Canario Bajo");
				
			}else {
				System.out.println("Canario Mediano");
			}
		}else {
			System.out.println("El canario no tiene tamanio");
		}
	}
}
