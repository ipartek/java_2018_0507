package com.ipartek.formacion.ejercicio1.poo;

/*La clase Canario:
• Tiene como atributos el sexo (M/H), la edad (entero) y el tamaño (real).
• La clase canario tiene dos constructores, uno inicializa el sexo y la edad según
dos parámetros que le llegan y otro también inicializa el tamaño.
• Tiene un método altura que dependiendo del tamaño del canario saca un
mensaje por pantalla (“Alto” si tamaño > 30, “Mediano” si tamaño [15..30] y
“Bajo” si tamaño < 15) */

public class Canario extends Ave{
	
	private Integer tamanyo;

	public Canario(char sexo, Integer edad) {
		super(sexo, edad);
	}
	
	public Canario(char sexo, Integer edad, Integer tamanyo) {
		super(sexo, edad);
		this.tamanyo = tamanyo;
	}
	
	public Canario(char sexo, Integer edad, Integer tamanyo, String nombreDueno, String nombreAve) {
		super(sexo, edad, nombreDueno, nombreAve);
		this.tamanyo = tamanyo;
	}
	
	public void altura() {
		String respuesta;
		
		if (this.tamanyo != null) {
			if (this.tamanyo < 15){
				respuesta = "Bajo";
			}else if (this.tamanyo > 30) {
				respuesta = "Alto";
			}else {
				respuesta = "Mediano";
			}
		}else {
			respuesta = "No tiene tamaño";
		}
		     
       	System.out.println(respuesta + "\n");  
	}

	public void setTamaño(Integer tamanyo) {
		this.tamanyo = tamanyo;
	}
	
}
