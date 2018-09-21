package com.ipartek.formacion.javaee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EjemploListener
 *
 */
public class EjemploListener implements ServletContextListener, HttpSessionListener {
	private static long contadorSesiones = 0;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session: ");
		System.out.println(contadorSesiones);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
		
	}

	
}
