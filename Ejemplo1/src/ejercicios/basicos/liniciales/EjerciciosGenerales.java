package ejercicios.basicos.liniciales;

import java.io.IOException;
import java.util.Scanner;

public class EjerciciosGenerales {
	
	public static void main(String[] args) {
		int numero;
		int aux;
		int inverso = 0;
		int cifra;
		
        Scanner sc = new Scanner(System.in);
        do {
        	System.out.print("Introduce un numero >= 10: ");
            numero = sc.nextInt();
        }
        while (numero<10);
        
        aux = numero;
        while(aux!=0) {
        	cifra = aux%10;
        	inverso = inverso*10 + cifra;
        	aux = aux/10;
        }
        if (numero == inverso) {
        	System.out.println(numero+" es capicua");
        }
        else {
        	System.out.println(numero+" no es capicua");
        }
}


	
	// SEMI ENTENDIDO	
	public static void main12(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto;
        int codigo;
        char opcion;
        do {
            System.out.print("Introduce un texto: ");
            texto = sc.nextLine();
            }
        while(texto.isEmpty());
      
        do {
        	System.out.println("Introduce un codigo");
        	codigo = sc.nextInt();
        }
        while (codigo<1);
        
        do {
        	System.out.println("(C) cifrar o (D) descifrar?: ");
        	opcion = (char)System.in.read();
        }
        while(Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
        	System.out.println("Texto cifrado: "+ cifradoCesar(texto,codigo));
        }
        else {
        	System.out.println("Texto descifrado: " + descifradoCesar(texto,codigo));
        }
	}

	
	private static String cifradoCesar(String texto, int codigo) {
		// TODO Auto-generated method stub
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo%26;
		for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
	}
	
	private static String descifradoCesar(String texto, int codigo) {
		// TODO Auto-generated method stub
		StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
	}

	// COPIADO COMPLETAMENTE
	public static void main11(String[] args) {
		int n1;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero => 1 y =< 3999:");
			n1 = sc.nextInt();
		}
		while(n1<1 || n1>3999);
	System.out.println(n1 + " en numeros romanos -> " + convertirANumerosRomanos(n1));

	}
	
	  //método para pasar a números romanos
	  public static String convertirANumerosRomanos(int numero) {
	      int i, miles, centenas, decenas, unidades;
	      String romano = "";
	     //obtenemos cada cifra del número
	      miles = numero / 1000;
	      centenas = numero / 100 % 10;
	      decenas = numero / 10 % 10;
	      unidades = numero % 10;

	     //millar
	      for (i = 1; i <= miles; i++) {
	             romano = romano + "M";
	      }

	     //centenas
	      if (centenas == 9) {
	          romano = romano + "CM";
	      } else if (centenas >= 5) {
	                     romano = romano + "D";
	                     for (i = 6; i <= centenas; i++) {
	                            romano = romano + "C";
	                     }
	      } else if (centenas == 4) {
	                      romano = romano + "CD";
	      } else {
	                  for (i = 1; i <= centenas; i++) {
	                         romano = romano + "C";
	                  }
	      }

	     //decenas
	      if (decenas == 9) {
	           romano = romano + "XC";
	      } else if (decenas >= 5) {
	                      romano = romano + "L";
	                      for (i = 6; i <= decenas; i++) {
	                            romano = romano + "X";
	                      }
	      } else if (decenas == 4) {
	                      romano = romano + "XL";
	      } else {
	                    for (i = 1; i <= decenas; i++) {
	                           romano = romano + "X";
	                    }
	      }

	     //unidades
	      if (unidades == 9) {
	           romano = romano + "IX";
	      } else if (unidades >= 5) {
	                      romano = romano + "V";
	                      for (i = 6; i <= unidades; i++) {
	                             romano = romano + "I";
	                      }
	      } else if (unidades == 4) {
	                      romano = romano + "IV";
	      } else {
	                  for (i = 1; i <= unidades; i++) {
	                         romano = romano + "I";
	                  }
	      }
	      return romano;
	  }

	
/*	public static void main09(String[] args) {
		double n1;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero mayor a 1:");
			n1 = sc.nextInt();
		}
		while (n1<=0);
		System.out.println("hola");
		int exp=0;
        double binario=0;
        while(n1!=0){
                double digito = n1 % 2;            
                binario = binario + digito * Math.pow(10, exp);   
                exp++;
                n1 = n1/2;
        }
        System.out.printf("Binario: %.0f %n", binario);
    }
*/

	
	public static void main08(String[] args) {
		int n1 = 0;
		int n2 = 1;
		int fibo;
		int veces;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero mayor a 1:");
		veces = sc.nextInt();
		System.out.println(n1);
		System.out.println(n2);
		for (int i = 1; i <= veces-2; i++) {
			fibo = n1+n2;
			n1=n2;
			n2=fibo;
			System.out.println(fibo);
		}
	}

	
	public static void main07(String[] args) {
		int n1, n2;
		int suma1 = 0; 
		int suma2 = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer numero:");
		n1 = sc.nextInt();
		System.out.println("Introduce el segundo numero:");
		n2 = sc.nextInt();
		
		for (int contador = 1; contador<n1; contador++) {
			if(n1%contador==0) {
				suma1 = suma1+contador;
			}
		}
		for (int contador = 1; contador<n2; contador++) {
			if(n2%contador==0) {
				suma2 = suma2+contador;
			}
		}
		if(suma1==n2 && suma2==n1) {
			System.out.println("Los numeros "+n1+" y "+n2+" son amigos");
		}
		else {
			System.out.println("Los numeros "+n1+" y "+n2+" no son amigos");
		}
	}

	
	public static void main062(String[] args) {
		int numero;
		int contador;
		int suma = 0;
		for(numero = 1; numero<=1000; numero++) {
			suma = 0;
			for (contador = 1 ; contador<=numero; contador++) {
				if(numero%contador==0) {
					suma = suma+contador;
					if(suma == numero) {
						System.out.println(numero);
					}
				}
			}
		}
		

	}
	
	public static void main061(String[] args) {
		int n, contador;
		int suma = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		n = sc.nextInt();
		for (contador = 1 ; contador<n; contador++) {
			if(n%contador==0) {
				suma = suma+contador;
			}
		}
		if(suma == n) {
			System.out.println("El numero "+n+" es un numero perfecto");
		}
		else {
			System.out.println("El numero "+n+" no es un numero perfecto");
		}
	}

	
	public static void main05(String[] args) {
		int n;
		int contador = 0;
		do {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero:");
			n = sc.nextInt();
			if(n%10==2) {
				contador++;
			}	
		}
		while(n>=0);
		System.out.println("Se han leido "+contador+" numero/s terminado/s en 2.");

	}

	
	public static void main04(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		n = sc.nextInt();
		System.out.println("Tabla del "+n);
		System.out.println("------------");
		for(int contador = 1; contador<=10; contador++) {
			System.out.println(n+" x "+contador+" = "+(n*contador));
		}
		
	}

	
	public static void main03(String[] args) throws IOException {
		double gradosC;
		char continuar;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce ºC:");
			gradosC = sc.nextInt();
			System.out.println(gradosC+"ºC son "+(gradosC+273)+"ºK");
			System.out.println("Repetir proceso? (S/N)");
			continuar = (char)System.in.read();
		}
		while(continuar !='n' || continuar !='N' );
	}

	
	public static void main02(String[] args) throws IOException {
		
		int numero;
		int contador = 0;
		char continuar;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce un numero:");
			numero = sc.nextInt();
			while (numero > 0) {
				numero = numero/10;
				contador++;
			}
			System.out.println("El numero tiene "+contador+" cifras");
			contador = 0;
			System.out.println("Continuar? (S/N)");
			continuar = (char)System.in.read();
		}
		while (continuar == 's' && continuar == 'S');
	
	}
	

	
	public static void main01(String[] args) {

	int A, B, aux;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduce un numero:");
	A = sc.nextInt();
	System.out.println("Introduce otro numero:");
	B = sc.nextInt();

	
	System.out.println("Valor de A = "+A);
	System.out.println("Valor de B = "+B);
	
	aux = A;
	A = B;
	B = aux;
	System.out.println("Nuevo valor de A = "+A);
	System.out.println("Nuevo valor de B = "+B);
	}
}
