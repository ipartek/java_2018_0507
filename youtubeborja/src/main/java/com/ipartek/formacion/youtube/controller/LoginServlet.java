package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.UsuarioMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioMySqlDAO dao;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	String login=request.getParameter("login");

	if(login.equalsIgnoreCase("login")){
	
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String password2=request.getParameter("password");
		
		try {
			dao = UsuarioMySqlDAO.getInstance();
		
		ArrayList<Usuario> usuarios= (ArrayList<Usuario>) dao.getAll();

		
		
for (int i = 0; i < usuarios.size(); i++) {
	if((usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) &&(usuarios.get(i).getPassword().equalsIgnoreCase(password2))){
		System.out.println("entrando en if");
		System.out.println(usuarios.get(i).getNombre());
		System.out.println(usuarios.get(i).getPassword());
		
		Usuario us=new Usuario(nombre,password2,email);
		
		request.getSession().setAttribute("user", us);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	
	
	
	
}	

response.sendRedirect("home.jsp");

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("es login");
		
		
		
		System.out.println();
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	if(login.equalsIgnoreCase("register")) {
		try {
			dao = UsuarioMySqlDAO.getInstance();

			// recoger parametros
			String email = request.getParameter("email");
			String nombre = request.getParameter("nombre");
			String password2=request.getParameter("password");
			// insertar
			Usuario v = new Usuario(nombre, password2,email);
			dao.insert(v);

			// pedir listado
			//ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.getAll();
			//request.setAttribute("Usuarios", usuarios);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
response.sendRedirect("home.jsp");		}
		
		
	}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
