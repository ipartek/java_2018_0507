package com.ipartek.supermercado.pojo;

public class Errores {
	String error="";
	public Errores(){
		
	}
	public String getError() {
		System.out.println("error"+ error);
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Errores(String error) {
		this.error=error;
	}
}
