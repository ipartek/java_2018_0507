package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password2");
		
		if (nombre == null || apellido == null || password == null || passwordRepeat == null) {
			throw new RuntimeException("No se han recibido los datos correctos");
		}
		
		LoginForm login = new LoginForm(nombre,apellido,password);
		
		if (validar(login, passwordRepeat)) {
			response.sendRedirect("login.jsp");
		}else {
			request.setAttribute("login", login);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}
	
	private boolean validar(LoginForm login, String passwordRepeat) {
		boolean resultado = true;
		if (login.getNombre().toString() == "") {
			login.setErrorNombre("Es obligatorio rellenar el nombre");
			resultado = false;
		}
		if (login.getApellido().toString() == "") {
			login.setErrorApellido("Es obligatorio rellenar el apellido");
			resultado = false;
		}
		if (login.getPassword().toString() == "") {
			login.setErrorPassword("Es obligatorio rellenar el password");
			resultado = false;
		}
		if (login.getPassword().toString() != passwordRepeat) {
			login.setErrorPassword("Las contraseñas deben ser identicas");
			resultado = false;
		}
		
		return resultado;
	}

}
