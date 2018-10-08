package com.ipartek.formacion.MF0967_3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967_3.modelo.UsuarioMySQLDAO;
import com.ipartek.formacion.MF0967_3.pojo.User;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static UsuarioMySQLDAO dao;
	static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;
	private static final long serialVersionUID = 8691018077622598020L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");

		User usuario = new User(nombre, clave);
		
		
		if(validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		} else {
			//TODO: Errores
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public static boolean validarUsuario(User usuario) {
		try {
			dao = UsuarioMySQLDAO.getInstance();
			ArrayList<User> usuarios = (ArrayList<User>) dao.getAll();
			for(User u: usuarios) {
				if(u.getNombre().equals(usuario.getNombre())&&u.getClave().equals(usuario.getClave())){
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
