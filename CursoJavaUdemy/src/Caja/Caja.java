package Caja;

public class Caja {

	int alto;
	int ancho;
	int profundo;
	
	Caja(){}
	
	Caja(int al, int an, int pr){
		this.alto = al;
		this.ancho = an;
		this.profundo = pr;
	}
	
	int calcularVolumen() {
		return alto * ancho * profundo;
	}
	
	int calcularVolumen(int ancho, int alto, int volumen) {
		return alto * ancho * profundo;
	}

}
