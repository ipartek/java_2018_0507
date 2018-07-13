package com.ipartek.formacion.aves;

public class DatosPersonales {
 private String nombrePajaro,nombreDueño;
	 /**
	 * 
	 */
	public DatosPersonales()
	 {
		 nombrePajaro="txarlie";
		 nombreDueño="iñaki";
	 }
	public String getNombrePajaro() {
		return nombrePajaro;
	}
	public void setNombrePajaro(String nombrePajaro) {
		this.nombrePajaro = nombrePajaro;
	}
	public String getNombreDueño() {
		return nombreDueño;
	}
	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}
}
