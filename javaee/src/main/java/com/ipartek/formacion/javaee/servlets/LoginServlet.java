package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("Si querías hacer un login, tienes que venir por post");
		
		pw.println("Hola a todos: " + new java.util.Date());
		
		String ruta = request.getContextPath();
		
		pw.println(ruta);
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoge los parametros introducidos en los inputs
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			//
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
			
		if("piero".equals(nombre) && "contra".equals(password)) {
			response.sendRedirect("principal.html");
		} else {
			//response.sendRedirect("error.html");
			request.setAttribute("errores", "");
			request.getRequestDispatcher("index.jsp");
		}
			
		
		//		PrintWriter pw = response.getWriter();
//		
//		pw.append("Hola ").append(nombre);
		
		//pw.println("Hola " + nombre);
		//pw.println(new StringBuilder("Hola ").append(nombre).toString());
	
	}

}
