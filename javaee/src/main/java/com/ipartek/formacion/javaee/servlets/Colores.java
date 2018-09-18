package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Colores {
//Test de cookis de javi
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		
		out.println("<form action='#' method='post'>");

		out.println("<select name='colorelegido'>");
		out.println("<option value='red'>rojo</option>");
		out.println("<option value='yellow'>amarillo</option>");
		out.println("<option value='green'>verde</option>");
		out.println("</select>");

		out.println("<button>Cambiar el color llamando al servlet</button>");
		out.println("</form>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    }
		
	
	
	
	
}
