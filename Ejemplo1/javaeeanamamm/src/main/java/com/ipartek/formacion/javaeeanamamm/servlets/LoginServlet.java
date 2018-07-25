package com.ipartek.formacion.javaeeanamamm.servlets;

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
		pw.println("Hola a todos: " + new java.util.Date());
		
		
		String ruta= request.getContextPath();
		pw.println(ruta);
		
		//para coger parametros de la ruta cuando añades por ejemplo ?nombre=ana
		String nombre = request.getParameter("nombre");
		
		if(nombre == null) {
			nombre = "DESCONOCIDO";
		}
		
		
		pw.append("Hola " ).append(nombre);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//para que admita ñ y simbolos en los campos etc.
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null | password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		if("ana".equals(nombre)&&"contra".equals(password)) {
			response.sendRedirect("principal.html");
		}else {
			response.sendRedirect("error.html");
		}
	}

}
