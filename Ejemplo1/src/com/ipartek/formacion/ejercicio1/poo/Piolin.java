package com.ipartek.formacion.ejercicio1.poo;

/*La clase Piolin:
• Tiene como atributos el sexo (M/H), la edad (entero) y el número de películas
(entero).
• Su constructor inicializa todos los atributos con valores que le llegan como
parámetros. */

public class Piolin extends Canario{
	
	private Integer numeroPeliculas;

	public Piolin(char sexo, Integer edad, Integer tamaño, Integer numeroPeliculas) {
		super(sexo, edad, tamaño);
		this.numeroPeliculas = numeroPeliculas;
	}

}
