package com.ipartek.formacion.ejercicio1.poo;

/*La clase Piolin:
• Tiene como atributos el sexo (M/H), la edad (entero) y el número de películas
(entero).
• Su constructor inicializa todos los atributos con valores que le llegan como
parámetros. */

public class Piolin extends Canario{
	
	private Integer numeroPeliculas;

	public Piolin(char sexo, Integer edad, Integer tamano, Integer numeroPeliculas, String nombreDueno, String nombreAve) {
		super(sexo, edad, tamano, nombreDueno, nombreAve);
		this.setNumeroPeliculas(numeroPeliculas);
	}

	public Integer getNumeroPeliculas() {
		return numeroPeliculas;
	}

	public void setNumeroPeliculas(Integer numeroPeliculas) {
		this.numeroPeliculas = numeroPeliculas;
	}
}
