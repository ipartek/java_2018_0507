package com.ipartek.javaeeEjercicios.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.javaeeEjercicios.accesodatos.UsuarioArrayDAO;
import com.ipartek.javaeeEjercicios.pojos.Usuario;
import com.ipartek.javaeeEjercicios.pojos.UsuarioException;
import com.ipartek.javaeeEjercicios.pojos.Error;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuariosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Usuario user;
	ArrayList<Usuario> usuarios=new ArrayList<>();
	Error error = new Error("");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		String remember = request.getParameter("checkRemember");
		
		System.out.println(usuario + password + remember);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		usuarios = (ArrayList<Usuario>) UsuarioArrayDAO.getInstance().getAll();
		
		String usuario = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		String remember = request.getParameter("checkRemember");
		
		System.out.println(usuario + password + remember);
		
		//Comprobaciones
		Usuario user = new Usuario();
		
		try {
			user.setEmail(usuario);
		}catch (UsuarioException e) {
		}
		
		try {
			user.setPassword(password);
		}catch (UsuarioException e) {
		}
				
		// Llamada a la logica de negocio
		if (!user.isErroneo()) {
			// Redireccion a vista (CORRECTO)
			//usuarios.add(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			// Redireccion a vista (ERROR)
			user.setMensajeError("Error al registrarse");
			request.setAttribute("user", user);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
