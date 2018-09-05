package Aritmetica_v3;

public class PruebaAritmetica {

	public static void main(String[] args) {

	int operandoA = 6;
	int operandoB = 2;
	
	Aritmetica obj1 = new Aritmetica(operandoA, operandoB);
	
	System.out.println("Operando A: "+operandoA+", operando B: "+operandoB);
	System.out.println("Resultado suma: "+obj1.sumar());
	System.out.println("Resultado resta: "+obj1.restar());
	System.out.println("Resultado multipicar: "+obj1.multiplicar());
	System.out.println("Resultado dividir: "+obj1.dividir());
	}

}
