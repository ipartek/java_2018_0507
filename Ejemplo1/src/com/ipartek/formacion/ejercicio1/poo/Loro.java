package com.ipartek.formacion.ejercicio1.poo;
/* La clase Loro:
• Tiene como atributos el sexo (M/H), la edad (entero), la región (N/S/E/O) y el
color (String).
• Tiene un constructor que inicializa todos los atributos con parámetros que le
llegan.
• Tiene un método deDondeEres que saca el mensaje “Norte”, “Sur”, “Este” u
“Oeste” dependiendo de la región de donde sea el loro.*/

public class Loro extends Ave{
	
	private char region;
	private String color;
	
	public Loro(char sexo, Integer edad, char region, String color) {
		super(sexo, edad);
		setRegion(region);
		this.color = color;
	}
	
	public void deDondeEres() {
		String respuesta;
		
		switch (this.region){
			case 'N':
				respuesta = "Norte";
				break;
			case 'S':
				respuesta = "Sur";
				break;
			case 'E':
				respuesta = "Este";
				break;
			case 'O':
				respuesta = "Oeste";
				break;
			default:
				respuesta = "No es de una region conocida";
				break;
		}
		
		System.out.println(respuesta +"\n");
	}
	
	public void setRegion(char region) {
		if (region != 'N' && region != 'S' && region != 'E' && region != 'O')
			throw new Error("Region desconocida, tiene que ser 'N', 'S', 'E', 'O'");
		this.region = region;
	}
}
