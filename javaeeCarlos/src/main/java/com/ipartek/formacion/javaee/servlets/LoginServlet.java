package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<br>Hola a todos: " + new java.util.Date());
		
		pw.println("");
		
		String ruta = request.getContextPath();
		pw.println(ruta);
		
		String nombre = request.getParameter("nombre");
		
		pw.append("<br>Hola ").append(nombre).toString();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String nombre = request.getParameter("nombre");
		
		if(nombre == null) {
			nombre = "DESCONOCIDO";
		}
			PrintWriter pw= response.getWriter();
		
			pw.append("Hola").append(nombre);
		
	}

}
