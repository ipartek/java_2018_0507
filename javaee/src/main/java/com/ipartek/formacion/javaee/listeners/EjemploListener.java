package com.ipartek.formacion.javaee.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class EjemploListener implements ServletContextListener, HttpSessionListener {

	private static long contadorSesiones = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.print("Sesión: ");
		System.out.println(++contadorSesiones);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
