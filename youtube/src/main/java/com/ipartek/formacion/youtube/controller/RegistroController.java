package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuarios;
import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String Email = request.getParameter("email");
			String Contraseña = request.getParameter("passsword");
			
			
			Usuarios usu = new Usuarios(Email, Contraseña);
			try {
				UsuariosMySqlDAO.getInstance().insert(usu);

				ArrayList<Usuarios> users = (ArrayList<Usuarios>) UsuariosMySqlDAO.getInstance().getAll();
				request.setAttribute("users", users);
				
			} catch (Exception e) {
				e.getMessage();
			}
			
			request.getRequestDispatcher("inicio").forward(request, response);
	}

}
