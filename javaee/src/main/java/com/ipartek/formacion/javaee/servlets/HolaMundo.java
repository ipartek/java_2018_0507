package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends HttpServlet {

	private static final long serialVersionUID = -2935269747296970141L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		if(nombre == null) {
			nombre = "Desconocido";
		}
		
		if(apellido == null) {
			apellido = "Desconocidez";
		}
		
        PrintWriter out = response.getWriter();
        
        out.println("Hola desde una servlet que manda texto plano");
        out.println(new java.util.Date());
        out.println("Ola ke passa");
        out.println(nombre);
        out.println(apellido);
	}

}
