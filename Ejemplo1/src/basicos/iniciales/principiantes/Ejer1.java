package basicos.iniciales.principiantes;

public class Ejer1 {

	public static void main1(String[] args) {
		int n = 5;
		double a = 250;
		char c = 's';
		
		System.out.println("El valor de n es: "+n);
		System.out.println("El valor de a es: "+a);
		System.out.println("Suma: "+(n+a));
		System.out.println("Resta: "+(a-n));
		System.out.println("El valor de c es: "+c);
	}
	
	public static void main5(String[] args) {
		 int a = 10;
		 
		 if(a % 2 == 0) {
			 System.out.println(a+" es par");
		 }else {
			 System.out.println(a+" es impar");
		 }
		 
	}
	
	public static void main6(String[] args) {
		int a = -1;
		
		//resultado = (condicion)?valor1:valor2;
		System.out.println((a>=0)?"positivo":"negativo");		
	}
	
	public static void main(String[] args) {
		int c = 5;

		System.out.println(c+(c >= 0?" es positivo":" es negativo"));
		System.out.println(c+(c % 2 == 0?" es par":" es impar"));
		System.out.println(c+(c % 5 == 0?" es multiplo de 5":" no es multiplo de 5"));
		System.out.println(c+(c % 10 == 0?" es multiplo de 10":" no es multiplo de 10"));
		System.out.println(c+(c >= 100?" es mayor que 100":" es menor que 100"));
		
	}

}