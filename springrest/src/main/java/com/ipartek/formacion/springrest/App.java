package com.ipartek.formacion.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	//SaludoController sc = new SaludoController();
    	
    	//System.out.println(sc.saludar("Javier").getContenido());
    	
    	SpringApplication.run(App.class, args);
    }
}
