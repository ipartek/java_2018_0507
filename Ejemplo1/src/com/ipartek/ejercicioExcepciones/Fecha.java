package com.ipartek.ejercicioExcepciones;

public class Fecha {
	private int año = 1;
	private int mes = 1;
	private int dia = 1;

	public static final int MESES_AÑO = 12;
	public Fecha() {
		
	}
	public void set(int año, int mes, int dia)
	{
		
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public static int getMesesAño() {
		return MESES_AÑO;
	}

	@Override
	public String toString() {
		return "Fecha [año=" + año + ", mes=" + mes + ", dia=" + dia + "]";
	}

//	public static boolean esBisiesto(int año);

	
}
