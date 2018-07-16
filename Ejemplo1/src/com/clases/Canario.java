package com.clases;

public class Canario extends Ave{
	float tamaino;
	
	public Canario(char sexo,int edad,float tamaino) {
		super(sexo,edad);
		this.tamaino=tamaino;
	}
	public void cantar() {};
	public Canario(char sexo,int edad){
		super(sexo,edad);
	}
	public void altura() {
		if(this.tamaino>15) {
		System.out.println("este pajaro es grande");
		}else if(this.tamaino<5) {
			System.out.println("este pajaro es peque�o");
		}else {
			System.out.println("este pajaro es mediano");
		}
	}

	public float getTamaino() {
		return tamaino;
	}

	public void setTamaino(float tamaino) {
		this.tamaino = tamaino;
	}
}
