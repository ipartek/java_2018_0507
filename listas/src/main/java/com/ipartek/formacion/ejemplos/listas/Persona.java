package com.ipartek.formacion.ejemplos.listas;

public class Persona {

	int numeroP=1;
	String nombreP="titiri";
	
	public Persona(int i, String string) {
		super();
		this.numeroP = i;
		this.nombreP = string;
		
	}

	public int getNumeroP() {
		return numeroP;
	}

	public void setNumeroP(int numeroP) {
		this.numeroP = numeroP;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	
}
