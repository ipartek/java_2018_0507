package com.ipartek.formacion.ejercicios.POO;

public class Loro extends Ave{

	public char region;
	public String color;
	
	public Loro(char sexo,
			Integer edad,
			char region,
			String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}

	public void deDondeEres() {
		/* Esta bien, pero tambien funciona con switch.
		if("n".equalsIgnoreCase(region)) {
			System.out.println("Norte");
		}else if("s".equalsIgnoreCase(region)) {
			System.out.println("Sur");
		}else if("e".equalsIgnoreCase(region)) {
			System.out.println("Este");
		}else if("o".equalsIgnoreCase(region)) {
			System.out.println("Oeste");
		}*/
		
		switch (this.region) {
		case 'N':
			System.out.println("Norte");
			break;
		case 'S':
			System.out.println("Sur");
			break;
		case 'E':
			System.out.println("Este");
			break;
		case 'O':
			System.out.println("Oeste");
			break;
		default:
			System.out.println("No es de una region conocida");
		}
	}
	
}
