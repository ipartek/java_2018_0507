package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.servlets.LoginForm;

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
		
		LoginForm login = new LoginForm(nombre, password);
		if (nombre == null || password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		//Comprobar si se ha introducido si el campo esta vacio o si
		//el nombre es el correcto
		if (nombre.equals("")) {
			login.setMensajeErrorUsuario("No se ha introducido el nombre, burribestia");
		}else if(!validarNombre(login)) {
			login.setMensajeErrorUsuario("El nombre no es el correcto, burribestia");
		}else if(validarNombre(login)) {
			login.setMensajeErrorUsuario("");
			//request.getSession().setAttribute("usuario", login);
		}
		//Comprueba si el campo esta vacio o si la clave es incorrecta
		if (password.equals("")) {
			login.setMensajeErrorClave("No se ha introducido la clave");
		}else if(!validarClave(login)) {
			login.setMensajeErrorClave("La clave no es la correcta");
		}else if(validarClave(login)){
			login.setMensajeErrorClave("");
			//request.getSession().setAttribute("contraseña", login);
		}
		//Si el usuario y contraseña son incorrectos manda mensaje
		if (validar(login)) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("Principal.jsp");
		} else {
			//login.setMensajeError("El usuario o contraseña no son correctos");
			login.setMensajeError("");
			request.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
	private boolean validar(LoginForm login) {
			return "batman".equals(login.getNombre()) && "batman".equals(login.getContrase�a());
	}
	private boolean validarNombre(LoginForm logName) {
		return "batman".equals(logName.getNombre());
	}
	private boolean validarClave(LoginForm logPassword) {
		return "batman".equals(logPassword.getContrase�a());
	}
}
