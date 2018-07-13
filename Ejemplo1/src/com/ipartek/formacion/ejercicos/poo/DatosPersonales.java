package com.ipartek.formacion.ejercicos.poo;

public class DatosPersonales {
	
	private String NombreAve;
	private String NombreDueno;
	
	
	
	public DatosPersonales (String NombreAve, String NombreDueno) {
		
		this.NombreAve = NombreAve;
		this.NombreDueno = NombreDueno;
		
	}
	
	
	public String getNombreAve() {
		return NombreAve;
	}
	
	public void setNombreAve(String nombreAve) {
		NombreAve = nombreAve;
	}

	

	public String getNombreDueno() {
		return NombreDueno;
	}

	public void setNombreDueno(String nombreDueno) {
		NombreDueno = nombreDueno;
	}
	
	
	
	
	
}
