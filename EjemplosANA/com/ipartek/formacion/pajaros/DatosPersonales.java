package com.ipartek.formacion.pajaros;

public class DatosPersonales {
	public static String nombreAve;
	public String nombreDueno;
	
	
	public DatosPersonales() {
		nombreAve="paquito";
		nombreDueno="PEPE";
	}
	
	public static String getNombreAve() {
		return nombreAve;
	}
	public static void setNombreAve(String nombreAver) {
		nombreAve=nombreAver;
		Piolin.setNombre(nombreAver);
	}	
	
}
