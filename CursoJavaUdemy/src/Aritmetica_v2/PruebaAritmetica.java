package Aritmetica_v2;

public class PruebaAritmetica {

	public static void main(String[] args) {

	Aritmetica obj1 = new Aritmetica();
	
	int resultado = obj1.sumar(5,6);
	
	System.out.println("Resultado suma directa obj1: "+resultado);
	System.out.println("Resultado suma atributos obj1: "+ obj1.sumar());
	
	Aritmetica obj2 = new Aritmetica(5,2);
	System.out.println("Resultado suma atributos obj2: "+ obj2.sumar());
		
	}

}
