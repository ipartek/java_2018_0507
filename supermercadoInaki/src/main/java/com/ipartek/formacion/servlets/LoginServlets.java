package com.ipartek.formacion.servlets;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iparte.formacion.logica.LogicaNegocio;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginServlets
 */
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogida de datos 
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email==null || password==null) {
			throw new RuntimeException("error");
		}
		Usuario usuario=new Usuario(email,password);
		if(LogicaNegocio.validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}else {
			request.setAttribute("user", usuario);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
