package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.youtube.model.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Usuario usuario = UsuarioMySqlDAO.getInstance().getByEmail(email);
			
			if(usuario != null && password.equals(usuario.getPassword())) {
				request.getSession().setAttribute("usuario", usuario);
			} else {
				request.setAttribute("alertatipo", "danger");
				request.setAttribute("alertatexto", "El usuario o la contraseña son incorrectos");
			}
			
			request.getRequestDispatcher("/").forward(request, response);

		} catch (Exception e) {
			throw new ControladorException("Error en el login", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
