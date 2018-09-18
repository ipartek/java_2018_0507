package com.ipartek.formacion.javaee.prueba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends HttpServlet {

	private static final long serialVersionUID = 6513190445025659794L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        if(nombre == null) {
        	nombre = "Desconocido";
        }
        if(apellido == null) {
        	apellido = "Desconocido";
        }
        
        PrintWriter out = response.getWriter();
        //out.println("Hola desde unaservlet que manda un texto plano");
        out.println("Ola ke pasa");
        out.println(nombre);
        out.println(apellido);
       // out.println(new java.util.Date());
    }
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		        doGet(request, response);
		    }

}
