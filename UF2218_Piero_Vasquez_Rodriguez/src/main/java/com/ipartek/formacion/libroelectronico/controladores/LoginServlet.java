package com.ipartek.formacion.libroelectronico.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libroelectronico.logica.LogicaNegocio;
import com.ipartek.formacion.libroelectronico.pojo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		if (nick == null || password == null) {
			throw new RuntimeException("Rellena los campos");
		}
		
		Usuario usuario = new Usuario(nick, password);
		
		boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);
		
		if (usuarioValido) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		}else {
			if (!usuarioValido) {
				request.setAttribute("errores", "El usuario no es valido");
			}
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
