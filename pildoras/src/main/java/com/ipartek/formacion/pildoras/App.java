package com.ipartek.formacion.pildoras;

import java.util.Date;
import java.util.logging.Level;

import lombok.extern.java.Log;

@Log
public class App {
	
	
	//https://projectlombok.org/features/all
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Persona p1=new Persona(1L,"Javier","Lete",new Date(),"ab");
        Persona p2=new Persona(1L,"Javier","Lete",new Date(),"a@b");
        
        if(p1.equals(p2)) {
        	//System.out.println(p1);
        	log.info("Iguales");
        }else {
        	System.out.println("diferentes");
        }
        //System.out.println(p1.getEmail());
        log.info(p1.getEmail());
        try {
			p1.setEmail("fdsfds");//Al hacer el set lombok mira en persona y te hace la comprobacion del seter
		} catch (Exception e) {
			log.log(Level.WARNING, "Excepcion detectada :", e);
			log.warning(e.toString());
			log.warning("Se ha detectado mail sin @");
		}
		// System.out.println(p1);
        log.info(p1.toString());
        
        //SE puede cambiar en el logging.properties que esta dentro de C:\Program Files\Java\jre1.8.0_181\lib
       
        log.log(Level.SEVERE, "mensaje SEVERE");
        log.log(Level.WARNING, "mensaje WARNING");
        log.log(Level.INFO, "mensaje detallado");
        log.log(Level.CONFIG, "mensaje CONFIG");
       
        
        
        log.log(Level.FINER, "mensaje detallado");
        log.log(Level.FINER, "mensaje MUY detallado");
        log.log(Level.FINEST, "mensaje super detallado");
        
    }//Modificando el log properties y añadiendole en Run configurations en vm arguments se pone: java.util.logging.SimpleFormatter
    //Te crea el fichero en C:\Users\curso
}
