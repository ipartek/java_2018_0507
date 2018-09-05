package Aritmetica;

public class PruebaAritmetica {

	public static void main(String[] args) {

		Aritmetica a = new Aritmetica();
		Aritmetica b = new Aritmetica();
		
		int resultadoA = a.sumar(5, 3);
		int resultadoB = b.sumar(10, 8);
		
		
		System.out.println("Resultado A: "+resultadoA);
		System.out.println("Resultado B: "+resultadoB);
	}

}
