package com.ipartek.formacion.ong.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ong.logica.LogicaNegocio;
import com.ipartek.formacion.ong.pojo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		if (nick == null || password == null) {
			throw new RuntimeException("Programador del login.jsp. Ya puedes poner un email y password.");
		}
		
		Usuario usuario = new Usuario(nick,password);
		
		boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);
		
		if (usuarioValido) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		}else {
			if (!usuarioValido) {
				request.setAttribute("errores", "El usuario no es valido");
			}
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
