package com.ipartek.formacion.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.supermercado.Usuario;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreUsu = request.getParameter("Usuario");
		String password = request.getParameter("password");
		
		Usuario usu = new Usuario();
		
		if (usu != null) {
			
			
		}
		
		
		
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
