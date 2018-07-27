package com.ipartek.formacion.javaee.servlets;

public class AhorcadoClass {
	private String letra;
	private String palabra;
	//private boolean acierto;
	private String MensajeErrorLetra;
	public AhorcadoClass(String letra, String palabra,/* boolean acierto,*/ String mensajeErrorLetra) {
		super();
		this.letra = letra;
		this.palabra = palabra;
		//this.acierto = acierto;
		MensajeErrorLetra = mensajeErrorLetra;
	}
	public AhorcadoClass(String letra/*, String palabra, boolean acierto*/) {
		super();
		this.letra = letra;
		//this.palabra = palabra;
		//this.acierto = acierto;
	}
	

	public AhorcadoClass() {
		this(""/*,""/*,false*/);
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	/*public boolean isAcierto() {
		return acierto;
	}
	public void setAcierto(boolean acierto) {
		this.acierto = acierto;
	}*/
	public String getMensajeErrorLetra() {
		return MensajeErrorLetra;
	}
	public void setMensajeErrorLetra(String mensajeErrorLetra) {
		MensajeErrorLetra = mensajeErrorLetra;
	}
	
	
}
