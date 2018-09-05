package PalabraReturn;

public class PalabraReturn {

	public static void main(String[] args) {
		int resultado = sumar(3, 2);
		System.out.println("Resultado: "+resultado);
		
	}
	
	public static int sumar(int a, int b) {
		if(a == 0 && b == 0) {
			System.out.println("Puede proporcionarvalores distintos a cero");
			return 0;
		}
		return a + b;
	}


}
