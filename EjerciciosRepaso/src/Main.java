import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int numero=0;
		String consRoma="";
		System.out.println("vamos a convertir un numnero en numeros romanos mete num:");
		Scanner teclado = new Scanner(System.in);
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
		muestraContenido("C:/Users/curso/Desktop/frases.txt");
		
	}
	  public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
	        String cadena,cadenaMaslarga="",cadenaMasPeke="";
	        int numLinea=0,aux=0,auxPek=0;
	       //List<Integer> puntos = new ArrayList<>();//<Punto>();
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {	     
	        	auxPek=cadena.length();
	            if(aux<cadena.length())
	            {
	           aux=cadena.length();
	           cadenaMaslarga=b.readLine();	           	
	            }
	            if(auxPek>cadena.length())
	            {
	            	auxPek=cadena.length();
	            	cadenaMasPeke=b.readLine();
	            }
	           
	        }
	        System.out.println(cadenaMaslarga);
	        System.out.println(cadenaMasPeke);
	        b.close();
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
