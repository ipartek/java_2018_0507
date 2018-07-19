package ejercicios.basicos.liniciales;

public class EstructuraIterativaRepetitiva {
	
	public static void main(String[] args) {
		int n = 100;
		for( n=100 ; n>=0; n--) {
			System.out.println(n);
		}
	}

	
	public static void main05(String[] args) {
		int n = 100;
		do {
			System.out.println(n);
			n--;
		}
		while (n>=1);
	}

	public static void main04(String[] args) {
		int n = 100;
		while (n>=0) {
			System.out.println(n);
			n--;
		}
	}

	
	public static void main03(String[] args) {
		int numero;
		for (numero=0 ; numero<=100 ; numero++) {
			System.out.println(numero);
		}
	}


	public static void main02(String[] args) {
		int numero = 1;
		do {
			System.out.println(numero);
			numero++;
		}
		while (numero <=100);
		
	}

	
	public static void main01(String[] args) {

		int numero = 1;
		while ( numero <=100 ) {
			System.out.println(numero);
			numero++;	
		}
	}

}
