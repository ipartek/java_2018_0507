package ejercicios.basicos.liniciales;

public class EstructuraIterativaRepetitiva {
	
	public static void main(String[] args) {
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
