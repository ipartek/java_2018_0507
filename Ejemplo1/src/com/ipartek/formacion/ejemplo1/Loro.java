package com.ipartek.formacion.ejemplo1;

/**
 * @class abstracta hereda de Ave
 * 
 *        Tiene como atributos el sexo (M/H), la edad (entero), la región
 *        (N/S/E/O) y el color (String). • Tiene un constructor que inicializa
 *        todos los atributos con parámetros que le llegan. • Tiene un método
 *        deDondeEres que saca el mensaje “Norte”, “Sur”, “Este” u “Oeste”
 *        dependiendo de la región de donde sea el loro.
 * @author AnaMAMM
 *
 */
public class Loro extends Ave {

	private char region;
	private String color;

	public Loro(char sexo, int edad, char region, String color) {

		super(sexo, edad);
		this.region = region;
		this.color = color;
		// this.numAvesCreadas++;

	}

	public void deDondeEres(char region) {

		if (region == 'N') {
			System.out.println("Norte");
		} else if (region == 'S') {
			System.out.println("sur");
		} else if (region == 'E') {
			System.out.println("Este");
		} else if (region == 'O') {
			System.out.println("Oeste");
		}

	}

	public void setRegion(char region) {
		this.region = region;
	}

	@Override
	public void cantar() {
		System.out.println("Piiio-piiiio loro bonito");

	}

}
