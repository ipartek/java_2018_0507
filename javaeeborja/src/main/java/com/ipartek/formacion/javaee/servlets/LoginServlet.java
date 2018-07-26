package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.RegisterForm;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		pw.println("Si querías hacer un login, tienes que venir por post");

		pw.println("Hola a todos: " + new java.util.Date());

		String ruta = request.getContextPath();

		pw.println(ruta);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		String nombrer = request.getParameter("nombrer");
		String passwordr = request.getParameter("passwordr");
		String emailr = request.getParameter("emailr");
		
		String mensaje="xD";
//		System.out.println(nombre);
//		System.out.println(password);
//		
		System.out.println(nombrer);
		System.out.println(passwordr);
		System.out.println(emailr);
		if(nombre == null || password == null) {
			//throw new RuntimeException("No se han recibido los datos de nombre y/o password");
			response.sendRedirect("error.html");
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

//		
		
		
		
		if (nombrer == null || passwordr == null || emailr == null) {
response.sendRedirect("error.html");		} 

			RegisterForm loginr = new RegisterForm(nombrer, passwordr, emailr,mensaje);
			if (validarr(loginr)) {
				//request.getSession().setAttribute("usuario", loginr);
				request.getSession().setAttribute("usuario", login);
				response.sendRedirect("principal.jsp");
				loginr.setNombre(nombrer);
				loginr.setEmail(emailr);
				login.setPassword(passwordr);
				
				System.out.println(login.getNombre());
				response.sendRedirect("principal.jsp");
				

			} else {
				response.sendRedirect("error.html");

			}

		

	}

	// PrintWriter pw = response.getWriter();
	//
	// pw.append("Hola ").append(nombre);

	// pw.println("Hola " + nombre);
	// pw.println(new StringBuilder("Hola ").append(nombre).toString());

	private boolean validar(LoginForm login) {

		return "borjañ".equals(login.getNombre()) && "contra".equals(login.getPassword());
	}

	private boolean validarr(RegisterForm login) {

		return true;
	}

}
