package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.javaee.modelos.LoginForm;

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
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		System.out.println(nombre);
		
		if(nombre == null || password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		LoginForm login = new LoginForm(nombre, password);
		
			
		if(validar(login)) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		} else {
			//response.sendRedirect("error.html");
			login.setMensajeError("El usuario o contraseña no son correctos");
			request.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
		
		//		PrintWriter pw = response.getWriter();
//		
//		pw.append("Hola ").append(nombre);
		
		//pw.println("Hola " + nombre);
		//pw.println(new StringBuilder("Hola ").append(nombre).toString());
	
	}

	private boolean validar(LoginForm login) {
		return "javierniño".equals(login.getNombre()) && "contra".equals(login.getPassword());


	}

}
