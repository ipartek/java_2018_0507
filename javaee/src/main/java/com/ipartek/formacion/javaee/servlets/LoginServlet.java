package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		System.out.println(nombre);
		
		
		LoginForm login = new LoginForm();
		
		try {
			login.setNombre(nombre);
		} catch (LoginFormException e) {
			login.setErrorNombre("*");
		}

			
		try {
			login.setPassword(password);
		} catch (LoginFormException e) {
			login.setErrorPassword("*");
		}

		if(validar(login)) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		} else {
			//response.sendRedirect("error.html");
			login.setMensajeError(login.getMensajeError() + " El usuario o contraseņa no son correctos");
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
		return "javierniņo".equals(login.getNombre()) && "contra".equals(login.getPassword());


	}

}
