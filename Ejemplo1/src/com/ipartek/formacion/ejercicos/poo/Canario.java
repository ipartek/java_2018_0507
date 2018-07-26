package com.ipartek.formacion.ejercicos.poo;


public class Canario extends Aves {

	
	private Integer tamano;
	
	public void Cantar() {
		
	}
	
	public Canario (String sexo, Integer edad)
	{
		super (sexo, edad);
	}
	
	public Canario (String sexo, Integer edad, Integer tamano)
	{
		super (sexo, edad);
		this.tamano = tamano;
	}
	
	public void Altura (Integer tamano)
	{			
		if (tamano >= 30)
		{
			System.out.println("Alto");
		}
		else if (tamano <= 15)
		{
			System.out.println("Bajo");
		}
		else 
		{
			System.out.println("Mediano");
		}
	}

	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}

	public Integer getTamano() {
		return tamano;
	}


}