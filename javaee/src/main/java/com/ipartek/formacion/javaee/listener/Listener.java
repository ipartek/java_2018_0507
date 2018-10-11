package com.ipartek.formacion.javaee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public class Listener implements ServletContextListener, HttpSessionListener {

   public static long contadorSesiones=0;

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
   @Override
    public void sessionCreated(HttpSessionEvent se)  { 
       System.out.println("Sesion: ");
       System.out.println("Contador sesiones: " + ++contadorSesiones);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("contextInitialized");
    }

	
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("sessionDestroyed");
    }

	

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	   System.out.println("contextDestroyed");
    }

	
	
}
