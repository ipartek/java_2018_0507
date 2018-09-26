package com.formacion.ipartek.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formacion.ipartek.logica.LogicaNegocio;
import com.formacion.ipartek.pojo.Usuario;

@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String logout = "";
		logout = request.getParameter("logout");
		if (logout != null && logout.equalsIgnoreCase("true")) {
			request.getSession().invalidate();
			logout = "false";

		}

		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recogida de datos
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getServletConfig().getServletContext()
				.getAttribute("daoUsuarios");
		if (email == null || password == null) {
			throw new RuntimeException("error");
		}
		Usuario usuario = new Usuario(email, password);
		// correccion de error meter el usurio en sesion cuando lo e comprobado
		if (LogicaNegocio.validarUsuario(usuario, usuarios, request)) {
			request.getRequestDispatcher("edicion").forward(request, response);
		} else {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
