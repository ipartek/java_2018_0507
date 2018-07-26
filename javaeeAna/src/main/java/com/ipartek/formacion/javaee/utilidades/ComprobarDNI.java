package com.ipartek.formacion.javaee.utilidades;


public class ComprobarDNI { 

   private static String dniAComprobar;

   public static void main(String[] args) {

        // dni a comprobar
        dniAComprobar =  "45671117r";

        boolean valido = comprobar(dniAComprobar);

        mostrarMensaje(valido);

        System.out.println("FIN DE PROGRAMA");
 }


  public static boolean comprobar(String dniAComprobar){
	  try {
	      // Array con las letras posibles del dni en su posición
	      char[] letraDni = {
	          'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
	      };  
	
	      String num= "";
	      int ind = 0;  
	
	      // boolean que nos indicara si es un dni correcto o no
	      boolean valido;
	
	      // existen dnis con 7 digitos numericos, si fuese el caso
	      // le añado un cero al principio
	      if(dniAComprobar.length() == 8) {
	           dniAComprobar = "0" + dniAComprobar;
	      }
	
	      // compruebo que el 9º digito es una letra
	      if (!Character.isLetter(dniAComprobar.charAt(8))) {
	           return false;  
	      }
	
	      // compruebo su longitud que sea 9
	      if (dniAComprobar.length() != 9){   
	           return false;
	      }  
	
	      // Compruebo que lo 8 primeros digitos sean numeros
	      for (int i=0; i<8; i++) {
	 
	           if(!Character.isDigit(dniAComprobar.charAt(i))){
	                 return false;    
	           }
	           // si es numero, lo recojo en un String
	           num += dniAComprobar.charAt(i);     
	      }
	
	      // paso a int el string donde tengo el numero del dni
	      ind = Integer.parseInt(num);
	
	      // calculo la posición de la letra en el array que corresponde a este dni
	      ind %= 23;
	
	      // verifico que la letra del dni corresponde con la del array
	      if ((Character.toUpperCase(dniAComprobar.charAt(8))) != letraDni[ind]){
	           return false;
	     }  
	     // si el flujo de la funcion llega aquí, es que el dni es correcto
	     return true;
	  } catch (Exception e){
		  System.out.println("DNI no valido");
	  }
	return false;
 } // fin comprobar

 /**
    * Funcion que muestra por consola el resultado
    * de la comprobacion de un dni
    * @return void
    * */
  static void mostrarMensaje(boolean nifValido){

       if (nifValido) {
            System.out.println(dniAComprobar + " es un NIF válido");
            System.out.println("Parte numérica del NIF: " +
            dniAComprobar.substring(0, 8) + ", letra: " + dniAComprobar.charAt(8));
       } else {
            System.out.println(dniAComprobar + " no es un nif válido");
       }  
  } // Fin mostrar mensaje

} //Fin ComprobarNif