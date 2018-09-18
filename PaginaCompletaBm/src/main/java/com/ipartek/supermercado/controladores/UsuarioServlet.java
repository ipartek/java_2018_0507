package com.ipartek.supermercado.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.supermercado.pojo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario user;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String usuario,password,formulario;
		 usuario=request.getParameter("mail");
		 password=request.getParameter("password");
		 formulario=request.getParameter("login");
		 formulario="algo";
		 System.out.println(usuario+password+formulario);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String usuario,password,formulario;
		 usuario=request.getParameter("mail");
		 password=request.getParameter("password");
		 formulario=request.getParameter("login");
		 System.out.println(usuario+password+formulario);
	
	}

}
