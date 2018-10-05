package com.ipartek.examen.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		if (user == null || pass == null) {
			throw new RuntimeException("Parámetros de inicio de sesión no encontrados");
		}

		Usuario usuario = new Usuario(user, pass);

		boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);

		if (usuario.isCorrecto() && usuarioValido) {
			request.getSession().setAttribute("user", usuario);
			request.getRequestDispatcher("main").forward(request, response);
		} else {
			if (!usuarioValido) {
				request.setAttribute("errores", "El usuario no es válido");
			}
			request.setAttribute("user", usuario);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
