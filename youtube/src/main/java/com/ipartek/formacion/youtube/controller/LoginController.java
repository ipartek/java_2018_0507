package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuarios;
import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.sendRedirect("inicio");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null || password == null) {
			throw new RuntimeException("Algun campo esta vacio");
		}
		
		Usuarios user = new Usuarios(email,password);
		
		  try {
			UsuariosMySqlDAO.getInstance().InicioSesion(email, password);
		} catch (Exception e) {
			e.getMessage();
		}
        
		  	request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("inicio").forward(request, response);
		
		
	}

}
