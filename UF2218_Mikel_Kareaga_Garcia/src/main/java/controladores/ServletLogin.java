package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Usuario;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		
		if(nombre=="" || password=="") {
		throw new RuntimeException("Introduzca nombre de usuario y contraseņa");
	}
		Usuario usuario = new Usuario(nombre, password);
		
		
		if(validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("/index").forward(request, response);
		} else {
			//TODO: Errores
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	private boolean validarUsuario(Usuario usuario) {
		//TODO: Poner lista de usuarios
		return true;
	}

}
