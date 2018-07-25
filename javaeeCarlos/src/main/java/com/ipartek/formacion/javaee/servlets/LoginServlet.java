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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// pw.println("<br>Hola a todos: " + new java.util.Date());
		pw.println("Si querías hacer un login, tienes que venir por post");

		pw.println("Hola a todos: " + new java.util.Date());

		String ruta = request.getContextPath();

		pw.println(ruta);
		/*
		 * String nombre = request.getParameter("nombre");
		 * 
		 * pw.append("<br>Hola ").append(nombre).toString();
		 */
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		System.out.println(nombre);
		
		if (nombre == null || password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		LoginForm login = new LoginForm(nombre, password);
		
		if ("batman".equals(login.getNombre())&& "Iambatman".equals(login.getContraseña())){
			response.sendRedirect("Principal.jsp");
		}else {
			//response.sendRedirect("Error.html");
			login.setMensajeError("");
			request.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		PrintWriter pw = response.getWriter();

		pw.append("Hola").append(nombre);
	}

}