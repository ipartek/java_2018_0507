package com.ipartek.formacion.ejemplos.librocompartido.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.librocompartido.pojos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		//System.out.println(nick+password);
		
		Usuario usuario = new Usuario(nick, password);
		//Chequeando si el usuario esta en la base de datos para dejarle entrar
		if(Usuario.checkUsuarioenBD(nick,password)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
