package com.ipartek.formacion.javaee.supermercado.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.modelo.LoginForm;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		Printwriter out = response.getWriter();
		String user = request.getParameter("username")
		String pass = request.getParameter("password")
				LoginForm login = new LoginForm(user, pass);
				///////////////////////////////////////////////////
				if (user == null || pass == null) {
					throw new RuntimeException("No se han recibido los datos" + " de nombre y/o password");
				}
				if (user.equals("")) {
					login.setMensajeErrorUsuario("No se ha introducido el nombre");
				} else if (!validarNombre(login)) {
					login.setMensajeErrorUsuario("El nombre no es el correcto");
				} else if (validarNombre(login)) {
					login.setMensajeErrorUsuario("");
				}
				// Comprobar si el campo esta vacio o si es incorrecto
				if (pass.equals("")) {
					login.setMensajeErrorClave("No se ha introducido la clave");
				} else if (!validarClave(login)) {
					login.setMensajeErrorClave("La clave es incorrecta");
				} else if (validarClave(login)) {
					login.setMensajeErrorClave("");
				}
				////////////////////////////////////////////////////////
				if (validar(login)) {
					//Creo sesion
					HttpSession session = request.getSession(true);
					request.getSession().setAttribute("usuario", login);
					response.sendRedirect("paginaPrincipal.jsp");
				} else {
					// request.setAttribute mantiene el nombre en caso de haberte
					// equivocado al escribir la contraseña o el usuario
					request.setAttribute("login", login);
					// procesa el request
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
	}
	
	
	
	private boolean validar(LoginForm login) {
		//crear array de objeto usuarios
		return "batman".equals(login.getNombre()) && "batman".equals(login.getClave());
	}

	private boolean validarNombre(LoginForm logName) {
		return "batman".equals(logName.getNombre());
	}

	private boolean validarClave(LoginForm logPassword) {
		return "batman".equals(logPassword.getClave());
	}
}
