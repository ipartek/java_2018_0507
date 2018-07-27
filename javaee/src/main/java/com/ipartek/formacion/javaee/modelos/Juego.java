package com.ipartek.formacion.javaee.modelos;

public class Juego {
	StringBuilder introduce = new StringBuilder();
	private String palabra;
	private String palabraSecreta ="secreto";
	private String mensajeError;
	
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public StringBuilder getIntroduce() {
		return introduce;
	}
	public void setIntroduce(StringBuilder introduce) {
		this.introduce = introduce;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public void iniciarbf(String pal) {
		for(int i=0;i<pal.length();i++){
			introduce.append("-");
		}palabra=introduce.toString();
	}
	public String comparar(String entra) {
		palabra=introduce.toString();
		for(int i=0;i<palabraSecreta.length();i++){
			char letrap=palabraSecreta.charAt(i);
			char letrae=entra.charAt(i);
			if(entra.equals(palabraSecreta)) {
				System.out.println("as ganado");
				this.palabra="";
					break;
				}
			if(letrap==letrae){
				
				introduce.setCharAt(i, letrae);
				palabra=introduce.toString();
			}		
		}return palabra;
	}
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPalabraSecreta() {
		return palabraSecreta;
	}
	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
	}
}
