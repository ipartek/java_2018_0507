package com.ipartek.formacion.examen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.pojo.Usuario;
import com.ipartek.formacion.examen.logica.LogicaLibro;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Tienes que insertar los datos en cada campo");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		if(validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		} else {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	private boolean validarUsuario(Usuario usuario) {
		//TODO: Poner lista de usuarios
		return true;
	}

}
