package ejercicios.basicos.liniciales;

public class Main {
	
	public static void main(String[] args) {
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
