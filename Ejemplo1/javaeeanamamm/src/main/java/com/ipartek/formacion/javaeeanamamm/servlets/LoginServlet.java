package com.ipartek.formacion.javaeeanamamm.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaeeanamamm.modelos.LoginForm;

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
		
		//para coger parametros de la ruta cuando a�ades por ejemplo ?nombre=ana
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
		
		//para que admita � y simbolos en los campos etc.
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null | password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		//objeto del modelo (pojo)
		LoginForm login = new LoginForm( nombre, password);
		
		
		
		if(validar(nombre, password)) {
			response.sendRedirect("principal.html");
		}else {
			//response.sendRedirect("error.html");
			request.setAttribute(arg0, arg1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private boolean validar(String nombre, String password) {
		return "ana".equals(nombre)&&"contra".equals(password);
	}

}
