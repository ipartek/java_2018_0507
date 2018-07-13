package com.ipartek.formacion.ejercicio1.poo;

/*La clase Piolin:
• Tiene como atributos el sexo (M/H), la edad (entero) y el número de películas
(entero).
• Su constructor inicializa todos los atributos con valores que le llegan como
parámetros. */

public class Piolin extends Canario{
	
	private Integer numeroPeliculas;
	private String nombrePiolin;
	private String nombreDuenio;
	private Integer tamanio;

	public Piolin(char sexo, Integer edad, Integer tamanio, Integer numeroPeliculas, String nombrePiolin, String nombreDuenio) {
		super(sexo, edad, tamanio);
		this.numeroPeliculas = numeroPeliculas;
		super.setNombres(new DatosPersonales(nombrePiolin, nombreDuenio));
	}

}
