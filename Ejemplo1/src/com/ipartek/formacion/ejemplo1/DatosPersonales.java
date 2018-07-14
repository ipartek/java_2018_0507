package com.ipartek.formacion.ejemplo1;
/**
 * @class Datos personales contiene el nombre del ave y del dueño
 * su constructor
 * y los getters y setters
 * 
 * @author AnaMAMM
 *
 */
public class DatosPersonales {

	
	/**
	 * atributos de instancia
	 */
	private String nombreAve;
	private String nombreDueno;
	
	/**
	 * Constructor con argumentos
	 * @param nombreAve
	 * @param nombreDueno
	 */
	public DatosPersonales(String nombreAve, String nombreDueno) {
		super();
		this.nombreAve = nombreAve;
		this.nombreDueno = nombreDueno;
	}

/**
 * getter
 * @return nombreAve
 */
	public String getNombreAve() {
		return nombreAve;
	}

/**
 * setter
 * @param nombreAve
 */
	public void setNombreAve(String nombreAve) {
		this.nombreAve = nombreAve;
	}

/**
 * getter
 * @return
 */
	public String getNombreDueno() {
		return nombreDueno;
	}

/**
 * setter
 * @param nombreDueno
 */
	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}
	
	
	
	
	
	
	
	
	
}
