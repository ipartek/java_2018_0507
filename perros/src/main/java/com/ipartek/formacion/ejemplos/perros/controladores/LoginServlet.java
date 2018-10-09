package com.ipartek.formacion.ejemplos.perros.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.perros.accesodatos.UsuariosMySQLDAO;
import com.ipartek.formacion.ejemplos.perros.modelos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		if(nick == null || password == null) {
			throw new ControladoresException("Se debe recibir los datos 'nick' y 'password'");
		}
		
		Usuario usuario = UsuariosMySQLDAO.getInstance().getByNick(nick);
		
		if(usuario == null || !password.equals(usuario.getPassword())) {
			usuario = new Usuario(nick, password);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("usuario", usuario);
		request.getRequestDispatcher("/WEB-INF/admin/").forward(request, response);
	}

}
