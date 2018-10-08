package com.ipartek.pabloDAO.paginaExamen.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.pabloDAO.paginaExamen.modelos.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Introduce un usuario y contraseña.");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		request.getSession().setAttribute("user", usuario);
		request.getRequestDispatcher("/admin/index").forward(request, response); 
	
	}

}
