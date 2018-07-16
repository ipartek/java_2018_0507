package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.clases.Ave;
import com.clases.DatosPersonales;
import com.clases.Loro;
import com.clases.Piolin;

public class Main {

	public static void main(String[] args) {/*
		en el cual se crea una
		instancia de la clase Piolin y otro de la clase loro.
		• Llamar al método quienSoy de las dos instancias
		• Llamar al método altura con la instancia del Piolín
		• Invocar al método deDondeEres con la instancia del Loro
		• Modificar el tamaño del Piolín y volver a invocar al método altura
		• Modificar la región del Loro
		• Mostrar el número de Aves creadas.*/
		
		Loro pajaroLoco=new Loro('H',5,'S',"azul");
		Loro locoPajaro=new Loro('M',3,'N',"gris");
		Piolin piolin=new Piolin('H',5,5,5);
		Piolin piolin2=new Piolin('M',1,1,1);
		Piolin piolin3=new Piolin('M',9,9,9);
		DatosPersonales dat=new DatosPersonales("pajarito","dueño");
		piolin.setNombres(dat);

		System.out.println("Elige una opcion:");
		StringBuilder sb=new StringBuilder("1 Mostrar Datos de Piolin y pajaro loco:\n").append("2-mostrar altura de piolin:\n").append("3-Mostrar de donde es el loro:\n").append("4-modificar tamaño de piolin y mostrar:\n").append("5-modificar region del loro:\n").append("6-mostrar el numero de aves creadas:\n").append("7-orquesta de pajaros\n").append("8-Mostrar nombre de piolin y de su dueño\n").append("9-salir");
		System.out.println(sb.toString());
		String entradaTeclado ="";
	    Scanner entradaEscaner = new Scanner (System.in);
	    boolean p=false;
	    int numEntero=0;
	    do {
	    do {
	    	System.out.println("ellige un numero del 1-7");
	    entradaTeclado = entradaEscaner.nextLine ();
	    try {
	    numEntero = Integer.parseInt(entradaTeclado);
	    	p=true;
	    	if(numEntero<0 || numEntero>9) {
	    		p=false;
	    	}
	    	}
	    catch (Exception e) {
	    	p=false;
	    	System.out.println("numero erroneo introduce otro");
	    	}
	    }while(p==false);
	    switch(numEntero){
	    	case 1:
	    		System.out.println("Pajaro Loco:\n");
	    		StringBuilder sb1=new StringBuilder("Edad: ").append(pajaroLoco.getEdad()).append("\nSexo: ").append(pajaroLoco.getSexo()).append("\nColor: ").append(pajaroLoco.color).append("\nRegion: ").append(pajaroLoco.getRegion());
	    		System.out.println(sb1.toString());
	    		System.out.println("\nPiolin:\n");
	    		StringBuilder sb2=new StringBuilder("Edad: ").append(piolin.getEdad()).append("\nSexo: ").append(piolin.getSexo()).append("\nTamaño: ").append(piolin.getTamaino()).append("\nNumero de peliculas: ").append(piolin.numeroPeliculas);
	    		System.out.println(sb2.toString());
	    		break;
	    	case 2:
	    		System.out.println("la altura de piolin es de:"+piolin.getTamaino());
	    		break;
	    	case 3:
	    		switch(pajaroLoco.getRegion()) {
	    			case 'S':
	    				System.out.println("este pajaro es del sur.");
	    				break;
	    			case 'N':
	    				System.out.println("este pajaro es del norte.");
	    				break;
	    			case 'E':
	    				System.out.println("este pajaro es del este:");
	    				break;
	    			case 'O':
	    				System.out.println("este pajaro es del oeste");
	    				break;
	    		}
	    		break;
	    	
	    	case 4:
	    		System.out.println("el tamaño de piolin era de:"+piolin.getTamaino()+"\n introduce un nuevo Piolin para el pajaro:");
	    		String strin;
	    		float tamain =1;
	    		boolean buli=true;
	    		Scanner escan2 = new Scanner (System.in);
	    		do {
	    			strin = escan2.nextLine ();
	    			try {
			    		tamain=Float.parseFloat(strin);
			    		piolin.setTamaino(tamain);
			    		System.out.println("el nuevo tamaño de Piolin es de:"+piolin.getTamaino());
	    			}catch (Exception e) {
	    				buli=false;
	    				System.out.println("tamaño incorrecto buelba a introducir tamaño:");
	    		}
	    		}
	    		while(buli==false);  			
	    		break;
	    		
	    	case 5:
	    		char value;
	    		boolean salir=false;
	    		Scanner preguntar = new Scanner (System.in);
	    		String rsp="";
	    		do {
		    		System.out.println("el loro es de:"+pajaroLoco.getRegion()+"introduce nueva region:");
		    	    System.out.println("N-norte, S-sur, E-este, O-Oeste");
		    	    rsp = preguntar.nextLine ();
		    	    
		    	    value=rsp.charAt(0);
		    	    if(value=='N'||value=='S'||value=='E'||value=='O') {
		    	    	pajaroLoco.setRegion(value);
		    	    	System.out.println("ahora el pajaro es de: "+pajaroLoco.getRegion());
		    	    	salir=true;
		    	    }
	    		}
	    	    while(salir==false);
	    		break;
	    	case 6:
	    		System.out.println(Ave.getNumeroAves());
	    		break;
	    	case 7:
	    		  Ave lista[]=new Ave[5];
	    		  lista[0]=locoPajaro;
	    		  lista[1]=piolin;
	    		  lista[2]=piolin2;
	    		  lista[3]=piolin3;
	    		  lista[4]=pajaroLoco;
	    		for(int i=0;i<lista.length;i++) {
	    			lista[i].cantar();
	    		}
	    		break;
	    	case 8:
	    		System.out.println(piolin.getNombres().getNombreD());
	    		System.out.println(piolin.getNombres().getNombreP());
	    		break;
	    	case 9:
	    		entradaEscaner.close();
	    		System.out.println("Cerrando programa..");
	    		break;
	    }

	    }while(numEntero!=9);
	}

}
