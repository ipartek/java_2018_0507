package com.ipartek.formacion.ejercicos.poo;

public abstract class Aves {

	private String sexo;
	private Integer edad;
	private DatosPersonales nombres;
	
	
	private Aves (String sexo, Integer edad)
	{
		this.sexo = sexo;
		this.edad = edad;
	}
	

	public void QuienSoy ()
	{
		System.out.println(sexo);
		System.out.println(edad);
	}
	
	abstract public void Cantar() ;


	public DatosPersonales getNombres() {
		return nombres;
	}


	public void setNombres(DatosPersonales nombres) {
		this.nombres = nombres;
	}
		

}

