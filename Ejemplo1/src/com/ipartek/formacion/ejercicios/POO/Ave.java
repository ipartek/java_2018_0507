package com.ipartek.formacion.ejercicios.POO;

public class Ave {
	
	public char sexo;
	public Integer edad;
	public static Integer numPajaros;
	
	
	
	public Ave(char sexo,
				Integer edad) {
		this.sexo= sexo;
		this.edad = edad;
		numPajaros++;
	}
	
	
	public void quienSoy() {
		System.out.println("Soy " + sexo +  " y tengo " + edad + " años");
	}
	
	public static void mostarNumAvesCreadas() {
		System.out.println("Se han creado " + numPajaros + " aves");
	}
}
