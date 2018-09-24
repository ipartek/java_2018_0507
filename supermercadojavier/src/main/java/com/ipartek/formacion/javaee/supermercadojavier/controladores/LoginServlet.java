package com.ipartek.formacion.javaee.supermercadojavier.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.supermercadojavier.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.supermercadojavier.pojo.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogida de datos
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null || password == null) {
			throw new RuntimeException("Programador del login.jsp. Ya puedes poner un email y password.");
		}
		
		//Cargamos el modelo
		Usuario usuario = new Usuario(email, password);
		
		//Lógica de negocio
		if(LogicaNegocio.validarUsuario(usuario)) {
			request.getSession().setAttribute("user", usuario);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		} else {
			request.setAttribute("user", usuario);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
