package com.ipartek.formacion.ejemplo1;

public class Ave {

	//atributos de instancia
	   char sexo;
	   int edad;
	   
	   //atributos de clase (static)
	   public static Integer numAvesCreadas =0;
	
	
	public Ave() {
		this.sexo = sexo;
		this.edad = edad;
		numAvesCreadas ++;
		
	}
	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;
		
	}
	
	public void quienSoy() {
		System.out.println("Sexo: " + sexo + "Edad: " + edad);
	}
	
	public static void mostrarAvesCreadas() {
		System.out.println(numAvesCreadas);
	}
	
	
}
