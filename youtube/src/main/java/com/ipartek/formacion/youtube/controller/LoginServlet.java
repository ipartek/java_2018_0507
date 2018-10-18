package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.model.UsuariosMySQLDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 6160433404127172730L;
	private static UsuariosMySQLDAO dao;
	
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuario = new Usuario(email, password);
		
		if(validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("inicio").forward(request, response);
			
		} else {
			//TODO: Errores
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			
	}
	public static boolean validarUsuario(Usuario usuario) {
		try {
			dao = UsuariosMySQLDAO.getInstance();
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.getAll();
			for(Usuario u: usuarios) {
				if(u.getEmail().equals(usuario.getEmail())&&u.getPassword().equals(usuario.getPassword())){
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
			
	}

}
