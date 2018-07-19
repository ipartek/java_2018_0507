package com.ipartek.formacion.ejercicios.POO;

public class Canario extends Ave{

	public Integer tamanio = 0;
	
	public Canario(char sexo, Integer edad) {
		super(sexo, edad);
	}
	public Canario(char sexo,
					Integer edad,
					Integer tamanio) {
		super(sexo,edad);
		this.tamanio = tamanio;
	}
	
	public void altura() {
		if (tamanio != null) {
			if(tamanio>30) {
				System.out.println("Grande");
			}else if(tamanio<30 && tamanio>15) {
				System.out.println("Mediano");
			}else {
				System.out.println("Pequeño");
			}
		}else {
			System.out.println("Falta el tamaño");
		}
	}
}
