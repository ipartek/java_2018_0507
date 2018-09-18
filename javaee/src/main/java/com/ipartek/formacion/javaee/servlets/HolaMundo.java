package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends HttpServlet {
	
	private static final long serialVersionUID = -2935269747296970141L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Clases de ejemplo:  C:\apache-tomcat-9.0.10\webapps\examples\WEB-INF\classes
		//http://localhost:8080/javaee/hola?nombre=ana
		//http://localhost:8080/javaee/hola?nombre=ana&apellido=mart
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hola desde servlet de texto plano");
		out.println(new java.util.Date());
		
		
		
		if(nombre==null)
			nombre="Desconocido";
		
		if(apellido==null)
			apellido="Desconocidez";
		
		out.println(nombre);
		out.println(apellido);
	
			
		
		
		
	}

}
