package com.ipartek.formacion.javaee.modelos;

public class Ahorcado {
private int numVidas=1;
String rutaImagen="ahorcad//ahorcado1.png";
String [] palabras={"autobus","rascacielos","verano","playa","porteria","baloncesto"};
String palabraElegida=palabras[(int) (Math.random()*6 + 0)-1];

	public Ahorcado() {
		
	}

}
