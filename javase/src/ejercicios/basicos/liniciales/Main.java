package ejercicios.basicos.liniciales;

public class Main {
	
	public static void main(String[] args) {
		
		int C = 55;
		
		System.out.println(C + (C>=0 ? " es positivo" : " es negativo"));
		System.out.println(C + (C%2 == 0 ? " es par" : " es impar"));
		System.out.println(C + (C%5 == 0 ? " es multiplo de 5" : " no es multiplo de 5"));
		System.out.println(C + (C%10 == 0 ? " es multiplo de 10" : " no es multiplo de 10"));
		System.out.println(C + (C>100 ? " es mayor que 100" : " es menor que 100"));
	}

	
	public static void main06(String[] args) {
		
		int B = -1;
		
		System.out.println(B + (B>=0 ? " es positivo" : " es negatvo"));
			
	}

	
	public static void main05(String[] args) {
	
	int A = 14;
	
	System.out.println(A + (A%2==0 ? " es par " : " es impar "));
	
/*	if(A%2 == 0) {
		System.out.println(A+" Es par");
	}
	else {
		System.out.println(A+" es inpar");
	}	
*/	
	}
	
	public static void main04(String[] args) {
		int A = 1;
		int B = 2;
		int C = 3;
		int D = 4;
		int temp;
		
		System.out.println("A = "+A);
		System.out.println("B = "+B);
		System.out.println("C = "+C);
		System.out.println("D = "+D);
		
		temp = B;
		B = C;
		C = A;
		A = D;
		D = temp;
		
		System.out.println("B toma el valor de C -> B = "+B);
		System.out.println("C toma el valor de A -> C = "+C);
		System.out.println("A toma el valor de D -> A = "+A);
		System.out.println("D toma el valor de B -> D = "+D);

		

	}

	
	public static void main03(String[] args) {
		int N = 1;
		
		System.out.println("Valor inicial de N = "+N);
		N = N+77;
		System.out.println("N + 77 = "+N);
		N = N-3;
		System.out.println("N - 3 = "+N);
		N = N*2;
		System.out.println("N x 2 = "+N);
	}


	public static void main02(String[] args) {
		int X = 1;
		int Y = 2;
		double M = 3.2;
		double N = 4.7;
		
		System.out.println(X);
		System.out.println(Y);
		System.out.println(M);
		System.out.println(N);
		
		System.out.println(X + " + " + Y + " = "+(X+Y));
		System.out.println(X + " - " + Y + " = "+ (X-Y));
		System.out.println(X + " x " + Y + " = " + (X*Y));
		System.out.println(X + " / " + Y + " = " + (X/Y));
		System.out.println(X + " % " + Y + " = " + (X%Y));
		System.out.println(N + " + " + M + " = " + (N+M));
		System.out.println(N + " - " + M + " = " + (N-M));
		System.out.println(N + " x " + M + " = " + (N*M));
		System.out.println(N + " / " + M + " = " + (N/M));
		System.out.println(N + " % " + M + " = " + (N%M));
		System.out.println(X + " + " + N + " = " + (X+N));
		System.out.println(Y + " / " + M + " = " + (Y/M));
		System.out.println(Y + " % " + M + " = " + (Y%M));
		System.out.println("Variable X = "+X+" el doble es "+(X*2));
		System.out.println("Variable Y = "+Y+" el doble es "+(Y*2));
		System.out.println("Variable M = "+M+" el doble es "+(M*2));
		System.out.println("Variable N = "+N+" el doble es "+(N*2));
		System.out.println(X+" + "+Y+" + "+N+" + "+M+" = "+(X+Y+N+M));
		System.out.println(X+" x "+Y+" x "+N+" x "+M+" = "+(X*Y*N*M));
	}

	
	
	public static void main01(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		double A = 4.56;
		char C = 'a';
		
		System.out.println("Variable N = "+N);
		System.out.println("Variable A = "+A);
		System.out.println("Variable C = "+C);
		System.out.println(N + " + " + A + " = " + (N+A));
		System.out.println(A + " - " + N + " = " + (A-N));
		System.out.println("Valor numerico de "+C+" = "+(int)C);

	}

}
