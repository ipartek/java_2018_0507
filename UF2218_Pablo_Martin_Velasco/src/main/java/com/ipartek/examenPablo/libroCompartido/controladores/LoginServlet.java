package com.ipartek.examenPablo.libroCompartido.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.examenPablo.libroCompartido.logica.LogicaNegocio;
import com.ipartek.examenPablo.libroCompartido.pojo.Usuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		//request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Introduce un usuario y contraseña.");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);
		
		if(usuario.isCorrecto() && usuarioValido) {
		
			request.getSession().setAttribute("user", usuario);
			request.getRequestDispatcher("index").forward(request, response); 
		} else {
			
			if(!usuarioValido) {
				request.setAttribute("errores", "El usuario no es valido");
			}
			request.setAttribute("user", usuario);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	

}