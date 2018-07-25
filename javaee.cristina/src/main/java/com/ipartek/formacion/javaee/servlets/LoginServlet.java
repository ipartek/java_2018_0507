package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		pw.println("Hola a todos: "+ new java.util.Date());
		
		String ruta = request.getContextPath();
		pw.println(ruta);
		
		String nombre = request.getParameter("nombre"); //mandame por el nombre que he puesto
		
		if(nombre == null) {
			nombre = "DESCONOCIDO";
		}
		pw.append("Hola ").append(nombre);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		System.out.print(nombre);
		
		if(nombre == null || password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		LoginForm login = new LoginForm(nombre, password);
		
		if("cris".equals(login.getNombre()) && "cris".equals(login.getPassword())) {
			response.sendRedirect("principal.jsp");
		}else {
			request.setAttribute("login",login);
			request.getRequestDispatcher("index.jsp").forward(request,  response);
			
		}
		
		//PrintWriter pw = response.getWriter();
		//pw.append("Hola ").append(nombre);
	}

}
