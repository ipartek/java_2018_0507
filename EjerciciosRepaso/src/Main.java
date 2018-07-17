import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//calculaRomano();
		//muestraContenido("C:/Users/curso/Desktop/frases.txt");
		//calcularMediaAlumnos();
		//calcuHastaMenos99();
		tresEnRaya();
		
	}
	public static void calculaRomano() {
		int numero=0;
		@SuppressWarnings("unused")
		String consRoma="";
		System.out.println("vamos a convertir un numnero en numeros romanos mete num:");
		//numero=Integer.parseInt(teclado.nextLine());
		try {
			numero=Integer.parseInt(teclado.nextLine());
			System.out.println(calcularRomano(numero));
			//System.out.println(calc);
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			Logger l = Logger.getLogger(Main.class.getName());
			l.log(Level.SEVERE, "quiero numero melllooon",e);
		}
		
	}
	
	  public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
	        String cadena,cadenaMaslarga="",cadenaMasPeke="";
	        @SuppressWarnings("unused")
			int numLinea=0,aux=0,auxPek=1000;
	       //List<Integer> puntos = new ArrayList<>();//<Punto>();
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {	     
	        	//auxPek=cadena.length();
	            if(aux<cadena.length())
	            {
	            	aux=cadena.length();
	            	cadenaMaslarga=cadena; 	
	            }
	            if (auxPek>=cadena.length())
	            {
	            	auxPek=cadena.length();
	            	cadenaMasPeke=cadena;
	            }
	           
	        }
	        System.out.println(cadenaMaslarga);
	        System.out.println(cadenaMasPeke);
	        b.close();
	    }
     public static void calcularMediaAlumnos()
     {
    	 ArrayList<Integer> notas = new ArrayList<>();
    	 Integer numAlumnos,nota,aux=1,sumaNotas=0;
    	 long media=0;
    	 @SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
    	 try {
    		 System.out.println("indique el numero de notas de alumno que va a insertar");
 			numAlumnos=Integer.parseInt(teclado.nextLine());
 			while(aux<=numAlumnos)
 			{
 				System.out.println("nota del Alumno "+aux+"?:");
 				aux++;
 				nota=Integer.parseInt(teclado.nextLine());
 				notas.add(nota);
 			}
 			for(Integer i=0;i<notas.size();i++) 			
 			sumaNotas=sumaNotas+notas.get(i); 			
 	
 			media=sumaNotas/numAlumnos;
 			System.out.println("la media es " + media);
 			//System.out.println(calc);
 			
 		} catch (NumberFormatException e) {
 			// TODO: handle exception
 			Logger l = Logger.getLogger(Main.class.getName());
 			l.log(Level.SEVERE, "quiero numero melllooon",e);
 		}

    	 
    	 
     }
     public static void tresEnRaya()
     {
    	 char [][] tablero=new char[3][3];
    	 int col,fil,hLibres=9;
    	 for(int i =0;i<3;i++)
    		 for(int h =0;h<3;h++)
    			 tablero[i][h]='.';	 
    	 
    	 mostrarTa(tablero);
    	 while(hLibres>0)
    	 {
    		 do {
	    	
			
	    	 System.out.println("inserte columna");
	    	 col=Integer.parseInt(teclado.nextLine());
	    	 System.out.println("inserte fila");
	    	 fil=Integer.parseInt(teclado.nextLine());
	    	 tablero[col-1][fil-1]='X';
	    	 mostrarTa(tablero);
	    	 	if(tablero[col-1][fil-1]!='X')
	    		 hLibres--;
    		 }while(tablero[col-1][fil-1]=='X');
    	 }
    			 
     }
     
     public static void mostrarTa(char tabler [][])
     {
    	 char [][] tablero=tabler;
    	 for(int i =0;i<3;i++)
    	 {
    		 System.out.println("");
    		 for(int h =0;h<3;h++)
    			 System.out.print(tablero[i][h]);
    	 }
    	 System.out.println("");
     }
     public static void calcuHastaMenos99()
     {
    	 
    	 ArrayList<Integer> notas = new ArrayList<>();
    	 Integer aux=0,suma=0;
    	 long media=0;
    	 try {
    		 System.out.println("meta numero hasta menos 99");
    		// aux=Integer.parseInt(teclado.nextLine());
 			while((aux=Integer.parseInt(teclado.nextLine()))!= -99)
 			{
 				notas.add(aux);
 			}
 			for (Integer i:notas) 			
 				suma=suma+i; 			
 			media=suma/notas.size();
 			System.out.println("media"+ media);
 			for (Integer i:notas) 			
 				if(i>media)
 					System.out.println(i +" mayor que la media " + media);
 			
 		} catch (NumberFormatException e) {
 			// TODO: handle exception
 			Logger l = Logger.getLogger(Main.class.getName());
 			l.log(Level.SEVERE, "quiero numero melllooon",e);
 		}
     }
     public static String calcularRomano(int num)
     {
    	 String conRoma="";
    	 for(;num>0;)
    	 {
	    	 if (num>=1000)
	 		{
	 			conRoma=conRoma+"M";
	 			num=num-1000;
	 		}
	    	 if (num>=500 && num<1000)
	  		{
	  			conRoma=conRoma+"D";
	  			num=num-500;
	  		}
	    	 if (num>=100 && num<500)
	  		{
	  			conRoma=conRoma+"C";
	  			num=num-100;
	  		}
	    	 if (num>=50 && num<100)
	  		{
	  			conRoma=conRoma+"L";
	  			num=num-50;
	  		}
	    	 if (num>=10 && num<50)
	  		{
	  			conRoma=conRoma+"X";
	  			num=num-1000;
	  		}
	    	 if (num>=5 && num<10)
	  		{
	  			conRoma=conRoma+"M";
	  			num=num-5;
	  		}
	    	 if (num>=1 && num<5)
	  		{
	  			conRoma=conRoma+"I";
	  			num=num-1;
	  		}
	    	 if(num==0)
	    		 break;
    	 }
    	 
		return conRoma;
    	 
    	 
     }
     
}
