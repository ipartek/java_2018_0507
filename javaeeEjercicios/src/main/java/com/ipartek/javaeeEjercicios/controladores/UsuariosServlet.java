package com.ipartek.javaeeEjercicios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.javaeeEjercicios.pojos.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuariosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Usuario user;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		//formulario = request.getParameter("login");
		//formulario = "algo";
		
		//System.out.println(usuario+password+formulario);
		System.out.println(usuario + password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String usuario = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		//String formulario=request.getParameter("login");
		
		System.out.println(usuario + password);
		//System.out.println(usuario + password + formulario);
	
	}

}
