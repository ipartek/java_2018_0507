package a.webEjers.ejercicios;

public class BubleAnidadoAbecedario {
/*	3. Programa que muestre lo siguiente por pantalla:
		ZYWXVUTSRQPONMLKJIHGFEDCBA
		YWXVUTSRQPONMLKJIHGFEDCBA
		WXVUTSRQPONMLKJIHGFEDCBA
		XVUTSRQPONMLKJIHGFEDCBA
		VUTSRQPONMLKJIHGFEDCBA
		UTSRQPONMLKJIHGFEDCBA
		TSRQPONMLKJIHGFEDCBA
		SRQPONMLKJIHGFEDCBA
		RQPONMLKJIHGFEDCBA
		QPONMLKJIHGFEDCBA
		PONMLKJIHGFEDCBA
		ONMLKJIHGFEDCBA
		NMLKJIHGFEDCBA
		MLKJIHGFEDCBA
		LKJIHGFEDCBA
		KJIHGFEDCBA
		JIHGFEDCBA
		IHGFEDCBA
		HGFEDCBA
		GFEDCBA
		FEDCBA
		EDCBA
		DCBA
		CBA
		BA
		A
		Como podemos ver, en este caso se trata de mostrar las letras del abecedario (sin la Ñ) en
		mayúsculas y en orden inverso. A continuación en cada fila mostrar una letra menos hasta
		llegar a mostrar solamente la A.*/
	

	public static void main(String[] args) {
		for (char x = 'Z'; x >= 'A'; x--) {
			for (char y = x; y >= 'A'; y--) {
				System.out.print(y);
			}
			System.out.println();
		}
	}
}