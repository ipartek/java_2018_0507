package Caja;

public class Prueba {

	public static void main(String[] args) {
		
		int alto = 6;
		int ancho = 2;
		int profundo = 5;

		Caja c1 = new Caja(alto, ancho, profundo);
		
		System.out.println("Alto: "+alto+", ancho: "+ancho+", profundo: "+profundo);
		
		int resultado = c1.calcularVolumen();
		
		System.out.println("Volumen de c1: "+resultado);
		
		Caja c2 = new Caja(2,5,8);
		
		System.out.println("Resultado de c2: "+c2.calcularVolumen());
		
	}

}
