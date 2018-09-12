package com.ipartek.formacion.javaee.libros.controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelo.Cabecera;
import com.ipartek.formacion.javaee.libros.modelo.LoginForm;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cabecera", new Cabecera("Login"));
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

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
			login.setMensajeErrorUsuario("No se ha introducido el nombre");
		}else if(!validarNombre(login)) {
			login.setMensajeErrorUsuario("El nombre no es el correcto");
		}else if(validarNombre(login)) {
			login.setMensajeErrorUsuario("");
		}
		//Comprueba si el campo esta vacio o si la clave es incorrecta
		if (password.equals("")) {
			login.setMensajeErrorClave("No se ha introducido la clave");
		}else if(!validarClave(login)) {
			login.setMensajeErrorClave("La clave no es la correcta");
		}else if(validarClave(login)){
			login.setMensajeErrorClave("");
		}
		//Si el usuario y contrasenia son incorrectos manda mensaje
		if (validar(login)) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("tabla.jsp");
		} else {
			login.setMensajeError("");
			request.setAttribute("login", login);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
	private boolean validar(LoginForm login) {
			return "batman".equals(login.getNombre()) && "batman".equals(login.getContrasenia());
	}
	private boolean validarNombre(LoginForm logName) {
		return "batman".equals(logName.getNombre());
	}
	private boolean validarClave(LoginForm logPassword) {
		return "batman".equals(logPassword.getContrasenia());
	}
}
