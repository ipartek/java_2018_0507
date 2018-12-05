package com.ipartek.formacion.pildoras;

import java.util.Date;
import java.util.logging.Level;

import lombok.extern.java.Log;
//http://www.informit.com/articles/article.aspx?p=361635&seqNum=4

@Log
public class App 
{
    public static void main( String[] args )
    {
        Persona p1 = new Persona(1L, "Javier", "Lete", new Date(), "ab@bb");
        Persona p2 = new Persona(1L, "Javier", "Lete", new Date(), "a@b");
        
        if(p1.equals(p2)) {
        	log.info("Son iguales");
        }
        
        log.info(p1.getEmail());
        
        try {
			p1.setEmail("asdfasd");
		} catch (Exception e) {
			log.log(Level.WARNING, "Excepción detectada: ", e);
			log.warning("Se ha detectado en main un email sin @");
		}
        
        log.info(p1.toString());
        
        log.log(Level.SEVERE, "mensaje error");
        log.log(Level.WARNING, "mensaje warning");
        log.log(Level.INFO, "mensaje información");
        log.log(Level.CONFIG, "mensaje configuración");
        log.log(Level.FINE, "mensaje detallado");
        log.log(Level.FINER, "mensaje muy detallado");
        log.log(Level.FINEST, "mensaje super detallado");
    }
}
