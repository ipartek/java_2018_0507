package com.ipartek.formacion.javaee.libros.modelos;

public class Descripciones {
	private String datos;
	
	
	
	public Descripciones(String datos) {
		super();
		this.datos = datos;
	}


	Descripciones (){
		
	}

	
	@Override
	public String toString() {
		return "Descripciones [datos=" + datos + "]";
	}


	public String getDatos() {
		return datos;
	}


	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	
}
