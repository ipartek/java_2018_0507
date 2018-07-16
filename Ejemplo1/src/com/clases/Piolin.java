package com.clases;
public class Piolin extends Canario{
	public int numeroPeliculas;
	public Piolin(char sexo, int edad, float tamaino,int numPeliculas) {
		super(sexo, edad, tamaino);
		this.numeroPeliculas=numPeliculas;
	}
	public int getNumeroPeliculas() {
		return numeroPeliculas;
	}
	public void setNumeroPeliculas(int numeroPeliculas) {
		this.numeroPeliculas = numeroPeliculas;
	}
	public void cantar() {
		System.out.println("Pio-pio soy un Piolín");

	}

}
