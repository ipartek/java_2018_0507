package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuarios;
import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;


@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String Email = request.getParameter("email");
			String Contraseña = request.getParameter("password");
			
			
			Usuarios usu = new Usuarios(Email, Contraseña);
			try {
				System.out.println(Email + Contraseña);
				UsuariosMySqlDAO.getInstance().insert(usu);
				
				
			} catch (Exception e) {
				e.getMessage();
			}
			
			response.sendRedirect("inicio");
	}

}
