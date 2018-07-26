package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Recogida de datos
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password2");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		
		// Empaquetado en modelo
		LoginForm registro = new LoginForm();
		
		try {
			registro.setNombre(nombre);
		}catch (LoginFormException e) {
		}
		
		try {
			registro.setApellido(apellido);
		}catch (LoginFormException e) {
		}
		
		try {
			if (registro.compararPassword(password, passwordRepeat)) {
				registro.setPassword(password);
			}
		}catch (LoginFormException e) {
		}
		
		try {
			registro.setEmail(email);
		}catch (LoginFormException e) {
		}
		
		try {
			registro.setDni(dni);
		}catch (LoginFormException e) {
		}
		
		
		// Llamada a la logica de negocio
		if (!registro.isErroneo()) {
			// Redireccion a vista
			request.getSession().setAttribute("usuario", registro);
			response.sendRedirect("principal.jsp");
		}else {
			// Redireccion a vista
			registro.setMensajeError("Error al registrarse");
			request.setAttribute("registro", registro);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
