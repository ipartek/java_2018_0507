package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

public class LoginServlet extends HttpServlet {

	private static final String USUARIO_POR_DEFECTO = "javierniño";
	private static final String PASSWORD_POR_DEFECTO = "contra";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//Recogida de datos
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		System.out.println("nombrerecib:" + nombre);
		
		//Empaquetado en Modelo
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

		//Llamada a l�gica de negocio
		if(!login.isErroneo() && validar(login)) {
			//Redirecci�n a vista
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		} else {
			//Redirecci�n a vista
			login.setMensajeError(login.getMensajeError() + " El usuario o contrase�a no son correctos");
			request.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private boolean validar(LoginForm login) {
		return USUARIO_POR_DEFECTO.equals(login.getNombre()) && PASSWORD_POR_DEFECTO.equals(login.getPassword());
	}

	private static final long serialVersionUID = 1L;
}
