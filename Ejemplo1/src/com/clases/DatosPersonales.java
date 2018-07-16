package com.clases;

public class DatosPersonales {
	
	String nombreP;
	String nombreD;
	
	public DatosPersonales(String nombreP, String nombreD) {
		super();
		this.nombreP = nombreP;
		this.nombreD = nombreD;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getNombreD() {
		return nombreD;
	}

	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}
	
}
